package 牛客网.特征提取;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 牛客网.特征提取.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            HashMap<String, Integer> temp = new HashMap<>();
            int m = scanner.nextInt();
            int max = 1;
            //遍历帧
            for (int j = 0; j < m; j++) {
                //清空辅助map
                temp.clear();
                int number = scanner.nextInt();
                //遍历帧内的坐标
                for (int k = 0; k < number; k++) {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    //拼接key
                    String key = String.valueOf(x) + " " + String.valueOf(y);
                    temp.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(temp.get(key), max);
                }
                map.clear();
                map.putAll(temp);
            }
            if (max <= 1) {
                System.out.println(1);
            } else {
                System.out.println(max);
            }
        }
    }
}
