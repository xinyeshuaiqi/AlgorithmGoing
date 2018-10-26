package pers.wmx.sort;

/*  桶排序
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 11:49
 **/
public class BucketSort {
    public static void bucketSort(int[] a) {

        int max = -1;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
        }
        int[] bucket = new int[max + 1];   //需要准备max+1个桶来装数   比如最大值是6，你需要装0，1，2，3，4，5，6这7个数的桶

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        //根据堆重新给数组赋值
        int index = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]> 0) {
                a[index] = j;
                index++;
                bucket[j]--;     //桶值减1，当为0时，遍历下一个桶
            }
        }
    }
    public static void main(String[] args) {
        int a[] ={1,2,5,1,13,5,7,6,22,2};
        bucketSort(a);

        for(int n:a){
            System.out.print(n+" ");
        }

    }
}
