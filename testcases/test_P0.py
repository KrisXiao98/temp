# -*- coding = utf-8 -*-
# @time:2022/4/16 22:54
# Author:KrisXiao
# @File:test_P0.py
# @Software:PyCharm

import pytest
import os
from common.handle_log import my_log
import allure
from lib.read_yaml import read_yaml
from web_driver.web_key import WebUi
from common.handle_path import getpath


@pytest.mark.P0
@allure.feature('PO级别用例')
class TestP0:
    @allure.story('login模块')
    def test_login(self, browser):
        browser.visit('https://www.baidu.com')
        browser.sleep(5)
        assert 1 == 1


if __name__ == '__main__':
    pytest.main(['-s', '--alluredir', '../report'])
    os.system('allure serve result')
