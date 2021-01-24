package 动态规划.nk001_最长公共子串;

/**
 * 动态规划.nk1_最长公共子串.
 *
 * @author chengxiaohai.
 * @date 2020/11/11.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Test {

    /**
     * 1AB2345CD 12345EF
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str1 = sc.nextLine();
            String str2 = sc.nextLine();

            long startTime = System.nanoTime();
            String r = LCS(str1, str2);
            System.out.println(r);
            System.out.println("LCS cost time:" + (System.nanoTime() - startTime));

            startTime = System.nanoTime();
            r = LCS1(str1, str2);
            System.out.println(r);
            System.out.println("LCS1 cost time:" + (System.nanoTime() - startTime));

            startTime = System.nanoTime();
            r = LCS2(str1, str2);
            System.out.println(r);
            System.out.println("LCS2 cost time:" + (System.nanoTime() - startTime));

        }
        sc.close();
    }

    /**
     * longest common substring 动态规划算法 dp[i][j]有两个分支 1. str1[i] = str2[j]  dp[i][j] = dp[i][j] + 1 2. str1[i] != str2[j]
     * dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        // write code here
        //零界值判断
        if (str1 == null || str2 == null || (str1.isEmpty() && str2.isEmpty())) {
            return "-1";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int str1L = chars1.length;
        int str2L = chars2.length;
        //动态规划结果
        int[][] dp = new int[str1L][str2L];
        Map<Integer, String> resultMap = new HashMap<>(str1L * (str1L - 1) + str2L - 1);

        //动态规划算法
        for (int i = 0; i < str1L; i++) {
            for (int j = 0; j < str2L; j++) {
                if (chars1[i] == chars2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        resultMap.put(i * str1L + j, "" + chars1[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        resultMap.put(i * str1L + j, resultMap.get((i - 1) * str1L + j - 1) + chars1[i]);
                    }
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                        resultMap.put(i * str1L + j, "");
                    } else {
                        if (dp[i][j - 1] > dp[i - 1][j]) {
                            dp[i][j] = dp[i][j - 1];
                            resultMap.put(i * str1L + j, resultMap.get(i * str1L + j - 1));
                        } else {
                            dp[i][j] = dp[i - 1][j];
                            resultMap.put(i * str1L + j, resultMap.get((i - 1) * str1L + j));
                        }
                    }
                }
            }
        }
        return resultMap.get(str1L * (str1L - 1) + str2L - 1);
    }

    /**
     * 滑动窗口算法
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS1(String str1, String str2) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 1;
        while (end < str1.length() + 1) {
            if (str2.contains(str1.substring(start, end))) {
                if (sb.length() < end - start) {
                    sb.delete(0, sb.length());
                    sb.append(str1, start, end);
                }
            } else {
                //这个算法我曾经疑惑，假如出现start>end，程序不是会crash么
                //通过debug发现，当start==end时，substring获取的是""，此时contains必然为true
                //所以当start == end时，必然会走end++分支
                start++;
            }
            end++;
        }
        if (sb.length() == 0) {
            return "-1";
        }
        return sb.toString();
    }


    public static String LCS2(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "-1";
        }
        int n1 = str1.length(), n2 = str2.length();
        if (n1 == 0 || n2 == 0) {
            return "-1";
        }
        int[][] dp = new int[n1 + 1][n2 + 1];

        int maxLen = 0, x = 0;
        for (int i = 1; i <= n1; i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        x = i;
                    }
                }
            }
        }

        return maxLen == 0 ? "-1" : str1.substring(x - maxLen, x);
    }

}
