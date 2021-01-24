package 牛客网.找零;

/**
 * 牛客网.找零.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N;
        N = cin.nextInt();
        System.out.println(solve(1024-N));

    }
    public static int solve(int now){
        return (now/64)+((now%64)/16)+((now%16)/4)+(now%4);
    }
}


