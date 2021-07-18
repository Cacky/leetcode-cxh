package 牛客网.雀魂启动;

/**
 * 牛客网.雀魂启动.
 *
 * @author chengxiaohai.
 * @date 2020/11/23.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    //判断是否和牌
    public static boolean isHe(int[] cardList) {
        int length = cardList.length;
        if (length == 0)
            return true;
        Arrays.sort(cardList);//给数组排序
        int count0 = count(cardList);

        //第一种情况：没出现雀头，且第一个数字出现的次数 >= 2,且去掉雀头剩下的数能组成和牌
        if (length % 3 != 0 && count0 >= 2 && isHe(Arrays.copyOfRange(cardList, 2, length)) == true)
            return true;
        //第二种情况：如果第一个数字出现次数 >= 3，且去掉这个刻子后剩下的能和牌
        if (count0 >= 3 && isHe(Arrays.copyOfRange(cardList, 3, length)) == true)
            return true;
        //第三种情况：如果出现顺子，且移除顺子后剩下的能和牌
        if (contains(cardList, cardList[0] + 1) && contains(cardList, cardList[0] + 2)) {
            int[] c_cardList = Arrays.copyOfRange(cardList, 1, length);
            int[] last = remove(c_cardList, cardList[0] + 1, cardList[0] + 2);
            if (isHe(last) == true)
                return true;
        }
        return false;
    }

    //移除数组内给定的两个数
    private static int[] remove(int[] cardList, int i, int i2) {
        int[] res = new int[cardList.length - 2];
        int x = 0, times1 = 0, times2 = 0;
        for (int j = 0; j < cardList.length; j++) {
            if (cardList[j] == i && times1 == 0) {
                times1++;
                continue;
            } else if (cardList[j] == i2 && times2 == 0) {
                times2++;
                continue;
            }

            res[x++] = cardList[j];
        }
        return res;
    }

    //判断数组内是否存在该数
    private static boolean contains(int[] cardList, int i) {
        for (int j = 0; j < cardList.length; j++) {
            if (cardList[j] == i)
                return true;
        }
        return false;
    }

    //统计数组内第一个数出现的次数
    private static int count(int[] cardList) {
        int res = 1;
        for (int i = 1; i < cardList.length; i++) {
            if (cardList[i] == cardList[0])
                res++;
            else
                continue;
        }
        return res;
    }

    //统计数组内某数出现的次数
    private static int timesOfI(int[] a2, int i) {
        int res = 0;
        for (int j = 0; j < a2.length; j++) {
            if (a2[j] == i)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] a = {1,1,1,1,2,2,3,3,5,6,7,8,9};
//        int[] a = {1,1,1,2,2,2,5,5,5,6,6,6,9};
//        int[] a = {1,1,1,1,2,2,2,5,5,5,7,7,7};
        int[] a = {1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 7, 7, 9};
        ArrayList<Integer> res = new ArrayList<>();
        int[] a2 = new int[a.length + 1];

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < a.length; j++) {
                a2[j] = a[j];
            }
            if (timesOfI(a2, i) == 4) {//如果该牌出现了四次，则不添加该数
                continue;
            }
            a2[a.length] = i;

            if (isHe(a2) == true)
                res.add(i);
        }

        System.out.println(res);
    }
}

