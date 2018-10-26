package pers.wmx.sort;

/**
 * 归并排序
 * 归并排序是稳定的排序
 * 时间复杂度为 O(nlogn)
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 11:45
 **/
public class mergeSort {
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {  //递归终止条件，分到只有一个数
            return;
        }
        int mid = (l+r)/2;       //分而治之
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);   //把两个有序的数组合并成一个有序的数组
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];    //辅助数组
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
