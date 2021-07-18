package com.theodorehai.test;

import java.util.Arrays;

/**
 * com.theodorehai.interview02.
 *
 * @author chengxiaohai.
 * @date 2021/6/15.
 */
public class Sort {

    // 快速排序
    public static void quickSort(int[] a,int low,int high){
        if(a==null || low > high){
            return;
        }
        int i = low,j = high, temp = a[low];
        while (i<j){
            while (i<j && a[j] > temp) j--;
            if(i<j) a[i++] = a[j];
            while (i<j && a[i] <= temp) i++;
            if(i<j) a[j--] = a[i];
        }
        a[i] = temp;
        quickSort(a,low,i-1);
        quickSort(a,i+1,high);
    }
    // 堆排序
    public static void heapSort(int[] a){
        int n = a.length;
        for (int i = n/2-1; i >=0 ; i--) {
            adjustHeap(a,i,n);
        }
        for (int i = n -1; i >=0 ; i--) {
            swap(a,0,i);
            adjustHeap(a,0,i);
        }
    }

    private static void adjustHeap(int[] a, int s, int n) {
        for (int i = s; i < n;) {
            int max = i;
            if(2*i+1<n && a[2*i+1]>a[max]){
                max = 2*i+1;
            }
            if(2*i+2 <n && a[2*i+2] > a[max]){
                max = 2*i+2;
            }
            if(i!=max){
                swap(a,i,max);
                i = max;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // 插入排序
    public static void insertSort(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp =a[i];
            int j = i-1;
            for (; j >=0 && a[j] > temp; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }

    // 希尔排序
    public static void shellSort(int[] a){
        double n = a.length;
        while (true){
            n = Math.ceil(n/2);
            int md = (int)n;
            for (int x = 0; x < md; x++) {
                for (int i = x+md; i < a.length; i+=md) {
                    int temp = a[i];
                    int j = i-md;
                    for (; j >=0 && a[j]>temp ; j-=md) {
                        a[j+md] = a[j];
                    }
                    a[j+md] = temp;
                }
            }
            if(md ==1){
                break;
            }
        }
    }

    // 选择排序
    public static void selectSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int flag = i;
            for (int j = i+1; j < a.length ; j++) {
                if(a[j] < temp){
                    temp = a[j];
                    flag = j;
                }
            }
            if(flag != i){
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }

    // 冒泡排序
    public static void bullonSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j+1] <a[j]){
                    int temp = a[j+1];
                    a[j+1] =a[j];
                    a[j] = temp;
                }
            }

        }
    }


    // 二分查找
    public static int search(int[] a,int target){
        int low = 0,high = a.length-1;
        if(target < a[low] || target>a[high]) return -1;
        while (low <= high){
            int middle = (low +high)/2;
            if(a[middle] > target){
                high = middle -1;
            }else if(a[middle] < target){
                low = middle +1;
            }else{
                return middle;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] data = new int[]{3, 6, 5, 4, 12, 4, 7};
        // shellSort(data);
        // quickSort(data,0,data.length-1);
        // bullonSort(data);
        // selectSort(data);
        // insertSort(data);
        heapSort(data);
        System.out.println(Arrays.toString(data));
        System.out.println(search(data, 12));
    }

}
