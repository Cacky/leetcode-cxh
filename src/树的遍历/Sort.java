package 树的遍历;

import java.util.Arrays;

/**
 * 树的遍历.
 *
 * @author chengxiaohai.
 * @date 2020/11/24.
 */
public class Sort {

    public static void insertSort(int[] a) {  //插入排序
        for (int i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            int temp = a[i]; // 设置数组中的第2个元素为第一次循环要插入的数据
            int j = i - 1;
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
            }
            a[j + 1] = temp;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
    }

    public static void selectSort(int[] a) {//选择排序
        if (a == null || a.length <= 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int flag = i; // 将当前下标定义为最小值下标
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {// a[j] < temp 从小到大排序；a[j] > temp 从大到小排序
                    temp = a[j];
                    flag = j; // 如果有小于当前最小值的关键字将此关键字的下标赋值给flag
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void heapSort(int[] a) {  //堆排序
        for (int i = a.length / 2 - 1; i >= 0; i--) {   //建堆，从n/2开始向上调整
            adjustHeap(a, i, a.length);
        }
        for (int j = a.length - 1; j >= 0; j--) {
            swap(a, 0, j);         //交换开始和最后位置上的数字
            adjustHeap(a, 0, j);    //交换之后再调整堆
        }
    }

    private static void adjustHeap(int[] a, int s, int n) {
        //由于根节点编号是从0开始的，所以其左子树是2*i+1
        for (int i = s; i < n; ) {
            int max = i;
            if ((2 * i + 1) < n && a[2 * i + 1] > a[max]) {
                max = 2 * i + 1;
            }
            if ((2 * i + 2) < n && a[2 * i + 2] > a[max]) {
                max = 2 * i + 2;
            }
            if (max != i) {
                swap(a, i, max);
                i = max;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

    public static void shellSort(int a[]) {//希尔排序
        double d = a.length; // 得到长度
        while (true) {
            d = Math.ceil(d / 2); // 得到向上取整的数
            int md = (int) d;
            for (int x = 0; x < md; x++) {//对被增量分割的每小组进行直接插入排序
                for (int i = x + md; i < a.length; i += md) {
                    int temp = a[i];
                    int j = i - md;
                    for (; j >= 0 && temp < a[j]; j -= md) {
                        a[j + md] = a[j];
                    }
                    a[j + md] = temp;
                }
            }
            if (md == 1) {
                break;
            }
        }
    }

    public static void quickSort(int a[], int low, int hight) {//快速排序
        if (low > hight) {
            return;
        }
        int i = low, j = hight, temp = a[low];// temp用表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= temp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            }
            while (i < j && a[i] < temp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];// 用比基准大的记录替换高位记录
            }
        }
        a[i] = temp;// 将基准数值替换回 a[i]
        quickSort(a, low, i - 1); // 对低子表进行递归排序
        quickSort(a, i + 1, hight); // 对高子表进行递归排序
    }

    public static void bubbleSort(int[] a) {//冒泡排序
        //从小到大排序
        for (int i = 0; i < a.length - 1; ++i) {
            // for (j = a.length - 1; j > i; --j) {
            //     if (a[j] < a[j - 1]) {
            //         temp = a[j];
            //         a[j] = a[j - 1];
            //         a[j - 1] = temp;
            //     }
            // }
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50, 22, 11, 48, 32, 60};
        // insertSort(data);
        shellSort(data);
        // quickSort(data, 0, data.length - 1);
        // heapSort(data);
        // selectSort(data);
        // bubbleSort(data);
        System.out.println(Arrays.toString(data));
    }

}
