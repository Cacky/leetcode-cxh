package 牛客网.万万没想到之抓捕孔连顺;

/**
 * 牛客网.万万没想到之抓捕孔连顺.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */

import java.util.Scanner;

public class Main {

    public static void run1(int n, int d, int[] position) {
        Long result = 0L;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (position[j] - position[i] > d) {
                    break;
                }
                for (int z = j + 1; z < n; z++) {
                    if (position[z] - position[i] > d) {
                        break;
                    } else {
                        result += 1L;
                    }
                }
            }
        }
        long mod = 99997867;
        System.out.println(result % mod);
    }

    public static int Cn3(int n) {
        if (n < 3) {
            return 0;
        }
        return (n * (n - 1) * (n- 2)) / 6;
    }

    public static long Cn2(long n) {
        if (n < 2) {
            return 0L;
        }
        return (n * (n - 1)) / 2;
    }

    public static void run2(int n, int d, int[] position) {
        long result = 0L;
        int lastj = 1;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = lastj; j < n; j++) {
                if (position[j] - position[i] <= d) {
                    result += Cn2(j - i);
                } else {
                    break;
                }
            }
            lastj = j;
        }
        long mod = 99997867;
        System.out.println(result % mod);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] position = new int[n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                position[i] = scanner.nextInt();
            }
            run2(n, d, position);
        }
    }
}


