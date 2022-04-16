# -*- coding = utf-8 -*-
# @time:2022/4/16 22:53
# Author:KrisXiao
# @File:read_yaml.py
# @Software:PyCharm

import yaml
from common.handle_path import getpath
from common.handle_log import my_log
import os


def read_yaml(filename):
    try:
        filename = os.path.join(getpath.get_data_path(), filename)
        with open(filename, 'r', encoding='utf-8') as f:
            my_log.info(msg='开始获取{}yaml文件数据'.format(filename))
            data = yaml.load(stream=f, Loader=yaml.FullLoader)
            return data
    except Exception as e:
        my_log.info(msg='获取yaml数据失败，error:{}'.format(e))


if __name__ == '__main__':
    print(read_yaml('test_data.yml'))
