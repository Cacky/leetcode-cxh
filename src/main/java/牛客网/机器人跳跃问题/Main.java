package 牛客网.机器人跳跃问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 牛客网.机器人跳跃问题.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            vis[i] = Integer.parseInt(str[i]);
        }
        int flag = 0;
        for (int i = n - 1; i >= 0; i--) {
            flag = (vis[i] + flag + 1) / 2;
        }
        System.out.println(flag);
    }

}
