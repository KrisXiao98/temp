# -*- coding = utf-8 -*-
# @time:2022/3/3 23:16
# Author:KrisXiao
# @File:main_run.py
# @Software:PyCharm
# -*- coding: utf-8 -*-
from common.handle_log import HandleLog

if __name__ == '__main__':
    haha = HandleLog()
    my_log1 = haha.make_log()
    for i in range(1, 100):
        my_log1.info('info')
    haha.change_level(my_log1, 'DEBUG')
    for i in range(0,100):
        my_log1.debug('debug')
