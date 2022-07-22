package Leecode.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class LeeCode1296 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPossibleDivide(new int[]{2,3,8,1}, 2);
    }
}

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        //如果想要够分，就必须满足是4的倍数
        if (nums.length % k != 0) {
            return false;
        }
        int count = nums.length / k;
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (count > 0) {
            //使用集合存储，使用Java8的新特性让int数组转为List
            //排序得到最小的数
            collect.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            int minNum = collect.get(0);
            for (int i = minNum; i < minNum + k; i++) {
                if (!(collect.contains(i))) {
                    return false;
                }
                //删除集合中的该元素
                for (Integer num: collect) {
                    if (i == num){
                        collect.remove(num);
                        break;
                    }
                }
            }
            count--;
        }
        return true;
    }
}