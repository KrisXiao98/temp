# -*- coding = utf-8 -*-
# @time:2022/3/3 23:40
# Author:KrisXiao
# @File:handle_log.py
# @Software:PyCharm

"""
    处理log模块
"""
from common.handle_path import getpath
import time
import logging
import os
from logging import handlers


class HandleLog:

    def make_log(self, name='log', level='INFO'):
        try:
            # 生成的log文件的名字和存放位置
            filename = os.path.join(getpath.get_log_path(),
                                    '{}.log'.format(time.strftime('%Y-%m-%d_%H-%M-%S', time.localtime())))
            # 创建日志器，名称默认为name
            logger = logging.getLogger(name=name)
            # 设置日志格式
            log_format = '%(asctime)s %(filename)s %(levelname)s  %(funcName)s  %(message)s'
            fmt = logging.Formatter(log_format)
            # 设置日志等级，默认为info
            logger.setLevel(level=level)
            # 创建控制台处理器,并设置日志信息格式
            sh = logging.StreamHandler()
            logger.addHandler(sh)
            sh.setFormatter(fmt)
            # when 按什么日期格式切分，接收指定字符串参数
            # “S”: Seconds
            # “M”: Minutes
            # “H”: Hours
            # “D”: Days
            # “W”: Week day (0=Monday)
            # “midnight”: Roll over at midnight
            # interval 是指等待多少个单位when的时间后，Logger会自动重建文件，这个文件的创建取决于filename + suffix，若这个文件跟
            # 之前的文件有重名，则会自动覆盖掉以前的文件，所以有些情况suffix要定义不能因为when而重复。
            # backupCount 是保留日志个数。默认的0是不会自动删除掉日志。若设为5，则在文件的创建过程中库会判断是否有超过这个5，若超过，
            # 则会从最先创建的开始删除。也可以选择，大小的方式。
            file = handlers.TimedRotatingFileHandler(filename=filename, when='H', interval=1, backupCount=1,
                                                     encoding='utf-8')
            file.setFormatter(fmt)
            logger.addHandler(file)
            return logger
        except Exception as e:
            print('error:', e)
            return False

    def change_level(self, change_logger, level):
        change_logger.setLevel(level)


# 调用这个对象，会默认生成一个日志器，先注释
my_log = HandleLog().make_log()
