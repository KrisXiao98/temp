# -*- coding = utf-8 -*-
# @time:2022/3/26 21:47
# Author:KrisXiao
# @File:handle_driver_options.py
# @Software:PyCharm

from selenium import webdriver


class Options:
    def __init__(self):
        self.options = webdriver.ChromeOptions()

    def default_options(self):
        """
           配置一个默认配置的浏览器选项
        :return: options
        """
        # 默认启动的driver窗体最大化
        self.options.add_argument('start-maximized')
        # 去掉提示正在执行自动化的警告条：没啥用，仅限于强迫症患者以及部分特别的系统。
        self.options.add_experimental_option('excludeSwitches', ['enable-automation'])
        # 这个现在已经用不了了，这是老版本去掉警告条的方式
        # options.add_argument('disable-infobars')
        # 添加本地缓存
        self.options.add_argument(r'--user-data-dir=C:\Users\xiaokai\AppData\Local\Google\Chrome\User Data')
        # 添加无头指令：有斟酌地进行使用。
        # options.add_argument('--headless')
        # 添加去掉密码弹窗管理
        prefs = {}
        prefs["credentials_enable_service"] = False
        prefs["profile.password_manager_enabled"] = False
        self.options.add_experimental_option("prefs", prefs)
        # 隐身模式
        # options.add_argument('incognito')
        # 指定窗口大小的指令
        # options.add_argument('window-size=2000,4000')
        # 默认浏览器启动的坐标位置
        # options.add_argument('window-position=200,400')
        return self.options

    def max_windows(self):
        """
            自己封装的其他选项
        :return:
        """
        pass
