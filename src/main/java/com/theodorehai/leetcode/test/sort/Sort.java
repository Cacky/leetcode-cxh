package com.theodorehai.leetcode.test.sort;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import java.util.Arrays;

/**
 * com.theodorehai.leetcode.test.sort.
 *
 * @author chengxiaohai.
 * @date 2021/3/18.
 */
public class Sort {

    public static void insertSort(int[] a) {
        int j;
        // for (int i = 1; i < a.length; i++) {
        //     int temp = a[i];
        //     for (j = i - 1; j >= 0 && a[j] > temp; j--) {
        //         a[j + 1] = a[j];
        //     }
        //     a[j + 1] = temp;
        // }
        for (int i = 1; i < a.length-1; i++) {
            int temp = a[i];
            for (j = i-1; j >=0 && a[j]>temp; j--) {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }

    public static void heapSort(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(a, i, n);
        }
        System.out.println(Arrays.toString(a));
        for (int j = n - 1; j >= 0; j--) {
            swap(a, 0, j);
            adjustHeap(a, 0, j);
        }

    }

    private static void adjustHeap(int[] a, int s, int n) {
        for (int i = s; i < n;) {
            int max =i;
            if(2*i+1<n && a[2*i+1]>a[max]){
                max = 2*i+1;
            }
            if(2*i+2<n && a[2*i+2]>a[max]){
                max = 2*i+2;
            }
            if(max != i){
                i=max;
                swap(a,i,max);
            }else{
                break;
            }
        }
        // for (int i = s; i < n; ) {
        //     int max = i;
        //     if (2 * i + 1 < n && a[2 * i + 1] > a[max]) {
        //         max = 2 * i + 1;
        //     }
        //     if (2 * i + 2 < n && a[2 * i + 2] > a[max]) {
        //         max = 2 * i + 2;
        //     }
        //     if (max != i) {
        //         swap(a, i, max);
        //         i = max;
        //     } else {
        //         break;
        //     }
        // }
    }

    private static void swap(int[] a, int s, int n) {
        int temp = a[s];
        a[s] = a[n];
        a[n] = temp;
    }

    public static void quickSort(int a[], int low, int hight) {
        if (low > hight) {
            return;
        }
        int i = low, j = hight, temp = a[low];
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < temp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = temp;
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, hight);
    }

    public static void quickSort2(int a[], int low, int hight) {
        if(low >hight){
            return;
        }
        int i = low,j= hight,temp=a[low];
        while (i<j){
            while(i<j && a[j]>= temp) j--;
            if(i<j) a[i++] = a[j];
            while(i<j && a[i]<temp) i++;
            if(i<j) a[j--] =a[i];
        }
        a[i] = temp;
        quickSort2(a,low,i-1);
        quickSort(a,i+1,hight);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 8, 2, 3, 1, 0};
        // insertSort(a);
        heapSort(a);
        // quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
