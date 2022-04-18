import time
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from common.handle_log import my_log
from common.handle_driver_options import Options


# 不同的driver初始化形式，自己挑喜欢的
def open_browser(type_):
    # 基于反射的形态来简化代码
    try:
        if type_ == 'Chrome':
            # 这里是返回一个浏览器驱动，且是以chrome——opions配置过的浏览器驱动对象
            my_log.info(msg='以options的配置启动浏览器')
            return webdriver.Chrome(options=Options().default_options())
        # 在这里可以输入其他浏览器
        else:
            # 比如输入Edge，就等于webdriver.Edge()
            return getattr(webdriver, type_)()
    except:
        my_log.info(msg='---默认使用谷歌浏览器（无缓存）---')
        return webdriver.Chrome()


# 此类定义进行webui自动化时所需要操作的selenium行为：
class WebUi:
    # 默认使用chrome浏览器
    def __init__(self, txt):
        self.driver = open_browser(txt)
        # 隐式等待
        self.driver.implicitly_wait(10)

    # 访问地址
    def visit(self, txt):
        self.driver.get(txt)

    # 最大化窗口
    def max_window(self):
        self.driver.maximize_window()

    # 关闭浏览器
    def quit(self):
        self.driver.quit()

    # 寻找元素,只是单纯的寻找到了元素，不能进行其他的操作
    # 用return是为了返回找到的这个元素，方便做断言等后续可能要做的操作
    def find_element(self, way, attribute):
        return self.driver.find_element(way, attribute)

    # 点击方法，此点击方法包含了寻找元素的步骤，一步到位点击某个特定元素
    def click(self, way, attribute):
        self.find_element(way, attribute).click()

    # 输入方法，也可用来上传文件,同样的一步到位
    def input(self, way, attribute, txt):
        self.find_element(way, attribute).send_keys(txt)

    # 切换iframe表单
    def switch_iframe(self, way, attribute):
        self.driver.switch_to.frame(self.find_element(way, attribute))

    # 返回默认窗体
    def back_default_window(self):
        self.driver.switch_to.default_content()

    # 多窗口切换--切换到第二个窗体，不关闭原来的页面
    def switch_window_not_close(self):
        self.driver.switch_to.window(self.driver.window_handles[1])

    # 多窗口切换--切换到第二个窗体，关闭原来的页面
    def switch_window_close(self):
        self.driver.close()
        self.driver.switch_to.window(self.driver.window_handles[1])

    # 截图方法
    def screenshots(self, path):
        # path = '../image/%s.png'%(time.strftime('%Y_%m_%d %H_%M_%S'))
        self.driver.get_screenshot_as_file(path % (time.strftime('%Y_%m_%d %H_%M_%S')))

    # 鼠标悬停方法
    def mouse_hover(self, way, attribute):
        ActionChains(self.driver).move_to_element(self.driver.find_element(way, attribute)).perform()

    # 显示等待
    def explicit_waiting(self, way, attribute):
        return WebDriverWait(self.driver, 10, 0.5).until(lambda el: self.find_element(way, attribute), message='等待失败')

    # 强制时间等待
    def sleep(self, txt):
        time.sleep(txt)

    # 断言文本
    def assert_text(self, way, attribute, expect):
        try:
            # 实际结果，找到的是该元素的文本
            reality = self.find_element(way, attribute).text
            # expect是预期结果，excel读写的时候会把预期结果读出来
            assert expect == reality, '断言失败'
            # 通过判断返回值来确定是否断言成功
            return True
        except Exception:
            # 当出现异常的时候给出日志，实际结果不等于预期结果
            return False

    # 断言属性
    def assert_attr(self, way, attribute, txt, expect):
        try:
            reality = self.find_element(way, attribute).get_attribute(txt)
            assert expect == reality, '断言失败'
        except Exception:
            return False

