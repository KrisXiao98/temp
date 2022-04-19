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
from common.handle_read_excel import GetExcelData


@pytest.mark.P0
@allure.feature('PO级别用例')
class TestP0:
    @allure.story('login模块')
    @pytest.mark.parametrize('test_data', read_yaml('login.yml'))
    def test_login(self, test_data, browser):
        with allure.step(f'访问{test_data["url"]}'):
            browser.visit(test_data["url"])
        with allure.step(f'点击{test_data["click_login"][-1]}'):
            browser.click(*test_data["click_login"])
        with allure.step('输入用户名和密码并点击'):
            browser.input(*test_data["input_name"])
            browser.input(*test_data["input_pwd"])
            browser.click(*test_data["click_login2"])
        assert browser.assert_text(*test_data["assert_text"]) is True


if __name__ == '__main__':
    # pytest.main(['-s'])
    pytest.main(['-s', '-v', '--alluredir', '../report'])
    os.system('allure serve result')
