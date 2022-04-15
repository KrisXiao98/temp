# -*- coding = utf-8 -*-
# @time:2022/3/3 23:50
# Author:KrisXiao
# @File:handle_path.py
# @Software:PyCharm
"""
    读取文件路径的方法
"""
import os


class GetPath(object):
    def __init__(self):
        # 获取当前文件绝对路径的父路径
        self.common_path = os.path.abspath(os.path.dirname(__file__))
        # 获取当前文件绝对路径的父路径的父路径
        self.project_path = os.path.abspath(os.path.dirname(self.common_path))

    def get_log_path(self):
        """

        :return: 生成的log文件存放地址
        """
        return os.path.join(self.project_path, 'logs')

    def get_config_path(self):
        """

        :return: 返回配置文件的地址的目录所在地
        """
        return os.path.join(self.project_path, 'conf')

    def get_data_path(self):
        """
            返回data文件夹的文件所在目录
        :return:
        """
        return os.path.join(self.project_path, 'data')


getpath = GetPath()

