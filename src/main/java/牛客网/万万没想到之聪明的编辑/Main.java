package 牛客网.万万没想到之聪明的编辑;

import java.util.Scanner;

/**
 * 牛客网.万万没想到之聪明的编辑.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */
public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count > 0) {
            String str = sc.next();
            checkStr(str);
            count--;
        }

    }


    public static void checkStr(String str) {
        int counts = str.length();
        for (int i = 0; i < counts; ) {
            if (i + 1 < str.length() && i + 2 < str.length() && str.charAt(i) == str.charAt(i + 1)
                && str.charAt(i + 1) == str.charAt(i + 2)) {
                str = str.substring(0, i) + str.substring(i + 1);
            } else {
                i++;
            }
        }

        counts = str.length();
        for (int i = 0; i < counts; ) {
            if (i + 1 < str.length() && i + 2 < str.length() && i + 3 < str.length()
                && str.charAt(i) == str.charAt(i + 1)
                && str.charAt(i + 2) == str.charAt(i + 3)) {
                str = str.substring(0, i + 2) + str.substring(i + 3);
            } else {
                i++;
            }
        }
        System.out.println(str);
    }
}