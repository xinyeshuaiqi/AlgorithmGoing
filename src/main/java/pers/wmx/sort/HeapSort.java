package pers.wmx.sort;

import pers.wmx.utils.MyUtils;

/**
 * 堆排序
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 11:48
 **/
public class HeapSort {
    public static void heapSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = 0; i < a.length; i++) {      //大根堆形成但可能无序
            heapInsert(a, i);
        }
        int size = a.length;
        MyUtils.swap(a, 0, --size);   //把最后一个位置和堆顶交换     意思是每次把最大值放在最后面,然后缩小堆的范围
        while (size > 0) {
            heapify(a, 0, size);    //可能小的数到堆顶，整个堆需要做一次调整modify，又形成大根堆
            MyUtils.swap(a, 0, --size);
        }
    }

    public static void heapInsert(int[] a, int index) {
        while (a[index] > a[(index - 1) / 2]) {           //比较当前节点与其父节点的大小
            MyUtils.swap(a, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] a, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && a[left + 1] > a[left] ? left + 1 : left;      //得到较大节点位置
            largest = a[largest] > a[index] ? largest : index;
            if (largest == index) {
                break;
            }
            MyUtils.swap(a, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
