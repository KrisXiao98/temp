# -*- coding = utf-8 -*-
# @time:2022/3/27 16:17
# Author:KrisXiao
# @File:test_case_webui01.py
# @Software:PyCharm


"""
    基于pytest进行测试用例的编写,这条用例是一个case就是一个sheet页。
"""

import pytest
import allure
import time
from common.handle_log import my_log
from web_driver.web_datadriven import webdriver
from lib.read_excel import read_excel


@pytest.mark.P0
@pytest.mark.webui_test
class TestCaseWeb01:



if __name__ == '__main__':
    pytest.main(['-s', '-v', 'test_case_webui01.py'])
