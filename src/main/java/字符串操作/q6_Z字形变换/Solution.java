package 字符串操作.q6_Z字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * o(n) 可用一boolean变量代替求余操作
 * 抛开题目描述，仅从最后图示输出来看（忽略掉其中的空格信息），
 * 其本质就是遍历一遍字符串，将各个字符输出到不同行中，
 * 核心点在于遍历过程中行号的变化规则：可以看出，当处于第一行时，行号的变化规则是加 1，
 * 当来到最后一行时，行号的变化规则是减 1。
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int col = 0;
        int n = 0;
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuffer temp = new StringBuffer();
            list.add(temp);
        }
        while (n < len) {
            int y = col % (numRows - 1);
            if (y == 0) {
                for (int i = 0; i < numRows && n < len; i++) {
                    list.get(i).append(s.charAt(n));
                    n++;
                }
            } else {
                list.get(numRows - 1 - y).append(s.charAt(n));
                n++;
            }
            col++;
        }
        String rs = "";
        for (int i = 0; i < list.size(); i++) {
            rs += list.get(i).toString();
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("LEETCODEISHIRING", 4));
    }
}
