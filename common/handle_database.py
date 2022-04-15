# -*- coding = utf-8 -*-
# @time:2022/3/4 23:21
# Author:KrisXiao
# @File:handle_database.py
# @Software:PyCharm
from common.handle_log import my_log
import pymysql
from common.handle_path import getpath
from common.handle_ini import HandleIni


class HandleDb:
    def __init__(self, host=None, port=None, user=None, pwd=None, db_name=None, charset='utf-8'):
        self.host = host
        self.port = port
        self.user = user
        self.pwd = pwd
        self.db_name = db_name
        self.charset = charset

    # 默认的一个数据库链接
    def default_connect_db(self):
        my_log.info('----采用默认数据库配置进行连接----')
        try:
            my_log.info('----部分参数为空，采用默认数据库配置链接----')
            default_host = HandleIni('conf_db.ini', sections='my_mysql', options='host').ini_str()
            default_port = HandleIni('conf_db.ini', sections='my_mysql', options='port').ini_int()
            default_user = HandleIni('conf_db.ini', sections='my_mysql', options='username').ini_str()
            default_pwd = HandleIni('conf_db.ini', sections='my_mysql', options='pwd').ini_str()
            default_db_name = HandleIni('conf_db.ini', sections='my_mysql', options='db_name').ini_str()
            default_charset = HandleIni('conf_db.ini', sections='my_mysql', options='charset').ini_str()
            default_connect = pymysql.connect(host=default_host, port=default_port, user=default_user,
                                              password=default_pwd, db=default_db_name, charset=default_charset)
            my_log.info('\n数据库连接成功！')
            return default_connect
        except Exception:
            my_log.info('----\n默认数据库链接错误----')
            raise Exception('\n默认数据库链接错误')

    # db链接
    def db_connect(self):
        try:
            self.conn = pymysql.connect(host=self.host, port=int(self.port), user=self.user, password=self.pwd,
                                        db=self.db_name, cursorclass=pymysql.cursors.DictCursor)
            my_log.info('\n数据库连接成功！')
        except Exception as e:
            my_log.error('\n数据库连接出现异常，错误信息：{}'.format(e))
            raise ('数据库连接出现异常，错误信息：{}'.format(e))
        return self.conn

    # 提交
    def __db_commit(self):
        my_log.info('\n提交数据库修改')
        self.conn.commit()
        my_log.info('\n提交数据库修改完成')

    # 回滚
    def __rollback(self):
        my_log.info('\n提交数据库回滚')
        self.conn.rollback()
        my_log.info('\n数据库回滚完成')

    # 关闭数据库连接
    def db_close(self):
        my_log.info(msg="\n开始关闭{}数据库连接")
        try:
            if self.conn:
                self.conn.close()
        except Exception as e:
            my_log.error('\n关闭数据库连接出现异常,错误信息：{}'.format(e))
            raise e
        finally:
            self.conn = None
            my_log.info(msg="\n{}数据库关闭")

    # 执行db操作
    def __db_execute(self, sql, need_commit=True):
        """
        :param sql: str
        :param need_commit: bool=True
        :return: list
        """
        my_log.info('\n开始执行db操作！')
        try:
            db_con = self.db_connect()
            # 创建游标，执行sql
            cur = db_con.cursor()
            my_log.info('\n游标创建成功！')
            cur.execute(sql)
            sql_result = cur.fetchall()
            my_log.info('\nsql执行成功，执行语句为：{}，执行结果为：{}'.format(sql, sql_result))
            if need_commit:
                db_con.commit()
                my_log.info('\nsql执行提交成功！')
            cur.close()
            my_log.info('\n游标关闭成功！')
        except Exception as ee:
            my_log.error('执行SQL：' + sql + '时，出现异常:{}'.format(ee))
            raise ee
        if sql_result is None and (sql.startswith('delete') or sql.startswith('update')) or sql.startswith('insert'):
            sql_result = 0
            my_log.info('\nsql执行返回结果为空或执行delete,update和insert操作，设置db操作返回结果为None')
        my_log.info(msg="\ndb操作执行完成！")
        my_log.info(msg="\ndb操作执行结果为：{}，数据类型为：{}".format(sql_result, type(sql_result)))
        return sql_result

    # 操作数据库delete数据
    def delete(self, sql, need_commit=True):
        my_log.info('\n执行delete删除操作！')
        self.__db_execute(sql, need_commit)
        self.__db_commit()
        my_log.info('\ndelete删除操作成功！')

    # 操作数据库insert数据
    def insert(self, sql, need_commit=True):
        my_log.info('\n执行insert插入操作！')
        self.__db_execute(sql, need_commit)
        self.__db_commit()
        my_log.info('\ninsert插入操作成功！')

    # 操作数据库update数据
    def update(self, sql, need_commit=True):
        my_log.info('\n执行update更新操作！')
        self.__db_execute(sql, need_commit)
        self.__db_commit()
        my_log.info('\nupdate更新操作成功！')

    # 操作数据库select数据,一条数据返回dict，多条数据返回list(list内的数据类型为dict)
    def select_sql(self, sql_command, type_conversion=True):
        """
        :param sql_command: str
        :param type_conversion: bool=True 查询结果类型转换，默认开启
        :return: dict,list
        """
        my_log.info('\n执行select查询操作！')
        query_result = self.__db_execute(sql_command)
        if type_conversion:
            new_query_result = self.__check_db_result_bytes(query_result)
        else:
            new_query_result = query_result
        if len(new_query_result) == 1:
            new_query_result = new_query_result[0]
            my_log.info('\n查询结果只有一条，将查询结果转化成dict！')
            my_log.info(msg="\nselect查询操作完成")
            my_log.info('\n最终获得的db数据为:{}'.format(new_query_result))
        return new_query_result

    # 检查db查询value结果数据类型，并进行类型转换
    def __check_db_result_bytes(self, query_result):
        """
        :param query_result: list
        :return: list
        """
        my_log.info(msg="\n对sql执行结果进行类型转换")
        if query_result:
            for result_dict in query_result:
                for key, value in result_dict.items():
                    if isinstance(value, bytes):
                        my_log.info('\n数据库查询结果存在，且数据类型为字节，转换为int值')
                        int_value = ord(value)
                        my_log.info('\n转化后的值为：{}'.format(int_value))
                        result_dict[key] = int_value
                    elif isinstance(value, Decimal):
                        my_log.info('\n数据库查询结果存在，且数据类型为Decimal，转换为float值')
                        int_value = float(value)
                        my_log.info('\n转化后的值为：{}'.format(int_value))
                        result_dict[key] = int_value
        my_log.info(msg="\n类型转换完成")
        my_log.info(msg="\n类型转换的结果为：{}，数据类型为：{}".format(query_result, type(query_result)))
        return query_result
