# -*- coding = utf-8 -*-
# @time:2022/3/27 16:10
# Author:KrisXiao
# @File:read_excel.py
# @Software:PyCharm

import pandas as pd
from common.handle_log import my_log
from common.handle_path import getpath
import os


def read_excel(filename, sheet_name=0):
    """
        读取excel数据，默认返回第一个sheet页的数据
    :param filename: excel文件名称，含.xlsx
    :param sheet_name: sheet页的名称
    :return: excel数据，dataframe格式
    """
    try:
        # my_log.info('开始读取{0}的数据，返回数据'.format(filename))
        # index_col 参数设置以第一列为默认列名称
        excel_data = pd.read_excel(os.path.join(getpath.get_data_path(), filename), index_col=0, sheet_name=sheet_name)
        return excel_data.values.tolist()
    except Exception as e:
        my_log.info('error:', e)


if __name__ == '__main__':
    print(read_excel('data.xlsx', sheet_name='case1'))
    # print(type(read_excel('data.xlsx')))
