# -*- coding = utf-8 -*-
# @time:2022/3/4 23:58
# Author:KrisXiao
# @File:operate_configfile.py
# @Software:PyCharm
import configparser
from operate_log import my_log
from operate_path import getpath
import os


class HandleIni:
    """
      读取ini配置文件
    """

    def __init__(self, filename, sections=None, options=None):
        self.config = configparser.ConfigParser()
        self.filename = os.path.join(getpath.get_config_path(), filename)
        self.sections = sections
        self.options = options
        self.config.read(self.filename, encoding='utf-8')

    # 获取str类型ini文件数据
    def ini_str(self, section=None, option=None):
        if self.options or self.sections:
            my_log.info('---开始获取str类型的ini文件数据---')
            str_value = self.config.get(section=self.sections, option=self.options)
        else:
            my_log.info('---获取str类型的ini文件数据失败---')
            raise TypeError("ini_str() missing 1 required positional argument: 'options' or 'sections'")
        return str_value

    def ini_int(self):
        if self.options or self.sections:
            my_log.info('---开始获取int类型的ini文件数据---')
            ini_value = self.config.getint(section=self.sections, option=self.options)
        else:
            my_log.info('---获取int类型的ini文件数据失败---')
            raise TypeError("ini_int() missing 1 required positional argument: 'options' or 'sections'")
        return ini_value

    def ini_float(self):
        if self.options or self.sections:
            my_log.info('---开始获取float类型的ini文件数据---')
            float_value = self.config.getfloat(section=self.sections, option=self.options)
        else:
            my_log.info('---获取float类型的ini文件数据失败---')
            raise TypeError("ini_float() missing 1 required positional argument: 'options' or 'sections'")
        return float_value

    def ini_boolean(self):
        if self.options or self.sections:
            my_log.info('---开始获取boolean类型的ini文件数据---')
            boolean_value = self.config.getboolean(section=self.sections, option=self.options)
        else:
            my_log.info('---获取boolean类型的ini文件数据失败---')
            raise TypeError("ini_boolean() missing 1 required positional argument: 'options' or 'sections'")
        return boolean_value

# cf = configparser.ConfigParser()
# cf.read(filenames=test.filename)
# print(cf.get(section='handlers', option='keys'))
