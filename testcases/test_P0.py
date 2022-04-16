# -*- coding = utf-8 -*-
# @time:2022/4/16 22:54
# Author:KrisXiao
# @File:test_P0.py
# @Software:PyCharm
import pytest
from common.handle_log import my_log
import allure
from lib.read_yaml import read_yaml
from web_driver.web_datadriven import WebUi


class TestP0:
    def setup_class(self):
        driver = WebUi("Chrome")
        return driver

    def teardown_class(self):
        self.setup_class().quit()

    @pytest.mark.P0
    @pytest.mark.login
    @allure.story("PO级case：login")
    # @pytest.mark.parametrize(data, read_yaml('test_data.yml'))
    def test_login(self):
        """
            login模块测试，此用例为webui测试
        """
        my_log.info(msg='开始执行login')
        self.setup_class.visit("https://www.baidu.com/")
        assert 1 == 1


if __name__ == '__main__':
    pytest.main(['-s'])