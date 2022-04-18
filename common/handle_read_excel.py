# -*- coding = utf-8 -*-
# @time:2022/4/14 20:15
# Author:KrisXiao
# @File:handle_read_excel.py
# @Software:PyCharm

from handle_path import getpath
from handle_log import my_log
import pandas as pd
import os


class GetExcelData:
    def __init__(self, filename, sheet_name):
        self.filename = os.path.join(getpath.get_data_path(), filename)
        self.sheet_name = sheet_name
        # 读取excel表格
        self.df = pd.read_excel(self.filename, sheet_name=sheet_name)
        # 需要用dataframe格式的用这个
        self.dataframe = pd.DataFrame(self.df)
        # 获取到所有行索引值list
        self.rows = self.df.index.values
        # 获取到所有列的值list
        self.columns = self.df.columns.values

    def get_excel_sheets(self):
        """
            获取excelsheet页的所有名字
        :return: list
        """
        try:
            my_log.info(msg='开始获取{}的所有sheet页名称'.format(self.filename))
            sheet_names = pd.read_excel(self.filename, sheet_name=None)
            return [i for i in sheet_names.df.keys()]
        except Exception as e:
            my_log.info(msg="获取sheet页失败,error:{}".format(e))

    # 获取sheet某一行的数据
    def get_sheet_row(self, row):
        """
            返回一行数据，以字典的格式
        :param row: 行号默认从0开始，且excel第一行不计入读取范围
        :return: dic
        """
        if row > 0:
            my_log.info(msg='开始获取sheet页第{}行的数据'.format(row))
            row -= 1
            return self.df.to_dict('index')[row]
        else:
            my_log.info(msg='获取sheet页第{}行的数据失败'.format(row))
            raise Exception('获取sheet页第{}行的数据失败'.format(row))

    # 读取sheet某一列的数据
    def get_sheet_column(self, column):
        """
            获取sheet某一列的数据，以字典格式
        :param column: 参数使用列名，非索引
        :return: dic
        """
        if column in self.columns:
            my_log.info(msg='开始获取sheet页\t{}\t列的数据'.format(column))
            return {column: self.df.to_dict('list')[column]}
        else:
            my_log.info(msg='获取sheet页\t{}\t列的数据失败'.format(column))
            raise Exception('获取sheet页\t{}\t列的数据失败'.format(column))

    def get_cell_data(self, row, column):
        """
            通过行列，获取一个cell的数据。excel第一行不计入查找范围。
        :return: str
        """
        # pandas默认不读取第一行，且都是以0作为首行列
        if row > 0:
            my_log.info(msg='开始获取第{0}行，第{1}列的数据'.format(row, column))
            cell_data = self.df.iloc[row - 1, column - 1]
            return cell_data
        else:
            my_log.info(msg='获取第{0}行，第{1}列的数据失败'.format(row, column))

    def get_all_data(self):
        """
            获取excel所有数据
        :return: list
        """
        all_data = []
        # 获取行号的索引，并对其进行遍历：
        my_log.info(msg='开始获取excel所有数据至list')
        for i in self.rows:
            # 根据i来获取每一行指定的数据 并利用to_dict转成字典
            row_data = self.df.loc[i, self.columns].to_dict()
            all_data.append(row_data)
        return all_data


if __name__ == '__main__':
    excel_data = GetExcelData('data.xlsx', 'case1')
    # print(excel_data.get_cell_data(0, 0))
    # print(excel_data.get_sheet_row(2))
    # print(excel_data.get_sheet_column('执行操作'))
    print(excel_data.get_all_data())
