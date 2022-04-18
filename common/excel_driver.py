# -*- coding = utf-8 -*-
# @time:2022/4/18 21:50
# Author:KrisXiao
# @File:excel_driver.py
# @Software:PyCharm
import openpyxl
import os
from web_driver.web_key import WebUi
from common.handle_path import getpath
from common.handle_log import my_log
from lib.excel_conf import passed, failed


def excel_runner(filename, sheet_name=None):
    """
        excel驱动，直接读取excel内容并执行测试用例。
    :param filename: excel文件名称
    :param sheet_name: sheetname名称，如果不传入，默认执行所有sheet的内容,可传入list
    :return:
    """
    filename = os.path.join(getpath.get_data_path(), filename)
    excel = openpyxl.load_workbook(filename)
    try:
        sheet_list = []
        if sheet_name is None:
            # 获取有的sheetname
            sheets = excel.sheetnames
            # 遍历出sheets中所有的sheet
            for sheet in sheets:
                # 打开具体的sheet页创建一个对象
                sheet_list.append(sheet)
        else:
            sheet_list.append(sheet_name)
        for sheet in sheet_list:
            sheet_temp = excel[sheet]
            # 添加一行日志表示执行的是第几个sheet页
            my_log.info('现读取sheet页:{}'.format(sheet))
            # 1.什么是sheet_temp.values:读取excel中所有的数据，取最大的行和列，没有数据的用None表示
            # 2.遍历出来的是什么：values是一个个的元组，数据是是一行行的数据，没有的用None表示
            for values in sheet_temp.values:
                '''
                2.读取用例执行要用的东西，区分：excel中第一列有编号则是要用的
                '''
                # 什么是values[0]:上面说到，values是一个元组，那么就可以通过索引来找到是什么值
                # 这里是判断遍历出来的元组的第一个值是不是int类型，即表格中每一行的第一个是不是int类型
                if type(values[0]) is int:
                    # 添加日志，表示正在执行表格中每一行第五个单元格的内容，这里写的是操作描述部分
                    my_log.info('正在执行：{}'.format(values[5]))
                    """
                    3.分析筛选出来的表的结构：
                    编号：不用管
                    执行操作、定位方法、定位路径、输入文本：结合关键字驱动类应用
                    操作描述：行为记录，可以添加到日志中进行输出
                    """
                    # 注意从这里开始处理的都是有用的数据，即每行开头都是含有编号的数据
                    # 定义一个字典data
                    data = {}
                    # 给字典添加键值对，键值具体的数据是什么不多说
                    # 把用来给代码执行的数据包装成了一个字典，有几行就有几个字典
                    data['way'] = values[2]
                    data['attribute'] = values[3]
                    data['txt'] = values[4]
                    data['expect'] = values[6]
                    ''' 
                    4.优化测试数据内容，将所有为none的数据全部清除出data中
                    '''
                    # 上面字典的操作中，还有键对应的值为None，通过获取字典的键来获取值并判断是否为none
                    for key in list(data.keys()):
                        if data[key] is None:
                            # 删除这个键值对，为什么不直接获取值原因就在这里，你只能通过键来删除键值对
                            del data[key]
                    '''
                    # 调用对应关键字来执行操作行为：分为三种不同的场景，不同场景幼不同处理
                    # 1.open_browser需要实例化类对象的情况
                    # 2.断言的情况，需要执行一个写入操作，比如实际结果：true，false
                    # 3.常规操作，点击、输入等
                    '''
                    # 这是第一种场景得处理办法，要创建浏览器驱动对象
                    if values[1] == 'open_browser':
                        wk = WebUi(values[4])
                    # 断言不会只有一种，所以我们设置只要在单元格里面包含assert字样，我们就认为他是断言函数
                    elif 'assert' in values[1]:
                        # 获取一个状态，这个状态是web_datadriven断言部分的返回值，True则为断言成功，False则为失败
                        status = getattr(wk, values[1])(**data)
                        # 基于status来对测试结果写到excel中
                        if status:
                            # 成功则pass方法
                            my_log.info('正在执行:写入Pass')
                            passed(sheet_temp.cell, values[0] + 2, 8)
                        else:
                            my_log.info('正在执行:写入Failed')
                            failed(sheet_temp.cell, values[0] + 2, 8)
                        # 执行保存
                        excel.save(filename)
                    else:  # 这里是第三种情况，调用其他的操作，点击，输入等操作
                        getattr(wk, values[1])(**data)
                        # wk.click(**data) values[1]就是读到第3行的时候就是open——browser以此类推
                        # **data是拆包的作用，wk.click(**data) = wk.click('way' = 'link text', 'attribute' = '登录')
    except Exception as e:
        my_log.exception('运行异常：{}'.format(e))

    finally:
        # 因为涉及到写入文件，所以要保存文件
        excel.close()


if __name__ == '__main__':
    excel_runner('data.xlsx')
