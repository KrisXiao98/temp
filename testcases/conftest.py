#!/usr/bin/env python
# -*- coding = utf-8 -*-
# @time:2022/3/27 19:32
# Author:KrisXiao
# @File:conftest.py
# @Software:PyCharm


import pytest
from web_driver.web_datadriven import WebUi
from util.operate_log import my_log


# 改进
@pytest.fixture(scope="session", autouse=True)
def open_browser():
    my_log.info('启动浏览器驱动')
    web_driver = yield WebUi('Chrome')
    my_log.info('执行session的teardown')
    web_driver.quit()
