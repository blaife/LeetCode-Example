package leetcode.t401binarywatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * """""""""""""""""""""""""""""""""""二进制手表"""""""""""""""""""""""""""""""""""
 * 题意：
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *          ○○●●
 *         ○●●○○●
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 案例:
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *  
 *
 * 注意事项:
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 */
public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for(int h=0; h<12; h++){
            for(int m=0; m<60; m++){
                if(Integer.bitCount(h)+Integer.bitCount(m)==num)
                    times.add(String.format("%d:%02d",h,m));
            }
        }
        return times;

    }
    public List<String> readBinaryWatch2(int num) {
        if (num == 0) {
            return result;
        }
        List<Integer> jg = new ArrayList<>();
        ans(jg, num, 0);
        return result;
    }

    public void ans(List<Integer> jg, int num, int index){
        if (index < 10) {
            ans(jg, num, index+1);
            jg.add(index);
            Map<String, Integer> map = udgementRange(jg);
            Integer hours = map.get("hours");
            Integer minutes = map.get("minutes");
            if (hours > 11 || minutes > 59) {
                jg.remove(jg.size()-1);
            } else {
                if (jg.size() > 0 && jg.size() == num) {
                    result.add(String.format("%d:%02d",hours,minutes));
                    jg.remove(jg.size()-1);
                    ans(jg, num, index+1);
                } else {
                    ans(jg, num, index+1);
                }
            }
        }
    }

    /**
     * 判断时间范围是否合法
     * @param jg
     * @return
     */
    public Map<String,Integer> udgementRange(List<Integer> jg){
        int hours = 0;
        int minutes = 0;
        for (int i = 0; i< jg.size(); i++) {
            int number = jg.get(i);
            if (number < 4) {
                hours += 1<<number;
            } else {
                minutes += 1<<(number-4);
            }
        }
        Map<String,Integer> map = new HashMap<>();
        map.put("hours", hours);
        map.put("minutes", minutes);
        return map;
    }

    public static void main(String[] args) {
        List<String> x = new Solution().readBinaryWatch(2);
        System.out.println(x);
    }


}

