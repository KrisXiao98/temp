package SystemClass.HomeWork;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class Work01 {
    public static void main(String[] args) {
        String str = "abcdef";
        String str2 = reserve(str, 1, 4);
        System.out.println(str2);
    }

    public static String reserve(String str, int start, int end){
        //对字符串指定位置翻转  abcdef,翻转为aedcbf
        /*
         * 1.转成char【】数组，才能进行交换
         * 2.双指针交换
         * 3.数组转为字符串
         */
        char[] chars = str.toCharArray();
        char temp = ' ';
        for(int i = start,j = end;i < j;i++, j--){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
