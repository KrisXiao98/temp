# -*- coding = utf-8 -*-
# @time:2022/3/3 23:16
# Author:KrisXiao
# @File:main_run.py
# @Software:PyCharm
# -*- coding: utf-8 -*-
import pytest
import os


# # mark = sys.argv[1]
# mark = os.environ['mark']
pytest.main(['-s', '-v',
             # '-m {}'.format(mark),
             # '-n 2', #多并发
             # '-x',
             # '--reruns=1', #断言失败重运行配置
             # '--reruns-delay=10', #重试时间间隔配置
             '--alluredir=./report', #report_data存放目录
             '--clean-alluredir' #report文件覆盖
             ])
os.system('allure generate ./report -o ./report --clean')  #生成测试报告