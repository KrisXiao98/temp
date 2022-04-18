# -*- coding = utf-8 -*-
# @time:2022/4/17 16:25
# Author:KrisXiao
# @File:conftest.py
# @Software:PyCharm

import pytest
import allure
from web_driver.web_key import WebUi

driver = None


@pytest.fixture(scope='session', autouse=True)
def browser():
    global driver
    if driver is None:
        with allure.step('打开一个浏览器驱动以运行全部的用例'):
            driver = WebUi('Chrome')
            driver.max_window()
            yield driver
        with allure.step('关闭这个浏览器'):
            driver.quit()
