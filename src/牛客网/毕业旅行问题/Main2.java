package 牛客网.毕业旅行问题;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 牛客网.毕业旅行问题.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] citys = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                citys[i][j] = sc.nextInt();
            }
        }

        List<Integer> gone = new LinkedList<>();
        for (int i = 1; i < n; ++i) {
            gone.add(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gone.size(); ++i) {
            int temp_int = gone.get(i);
            gone.remove(i);
            min = Math.min(min, fun(temp_int, gone, citys) + citys[0][temp_int]);
            gone.add(i, temp_int);
        }

        System.out.println(min);
    }

    public static int fun(int head, List<Integer> gone, int[][] citys) {
        if (gone.size() == 0) {
            return citys[head][0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gone.size(); ++i) {
            int temp_int = gone.get(i);
            gone.remove(i);
            min = Math.min(min, fun(temp_int, gone, citys) + citys[head][temp_int]);
            gone.add(i, temp_int);
        }

        return min == Integer.MAX_VALUE ? citys[head][0] : min;
    }
}

