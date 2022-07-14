package ExceptionDemo.Demo;

public class Test {
    public static void main(String[] args) {
        try {
            String str = "你好";
            int a = Integer.parseInt(str);
            System.out.println("数字:" + a);
        }catch (NumberFormatException e){
            System.out.println("数字格式（子类）异常写在前面" + e);
        }
        catch (Exception e) {
            System.out.println("父类异常信息：" + e);
        } finally {
            System.out.println("finally输出");
        }
        System.out.println("程序继续执行");
    }
}

