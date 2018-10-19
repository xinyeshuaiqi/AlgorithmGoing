package pers.wmx.demo;

import pers.wmx.utils.MyUtils;

/**
 * @author: wangmingxin1
 * @create: 2018-10-19 17:55
 **/
public class SimpleDemo {

    //逆序数组  1/2 * n 次swap操作 : O(n)
    public static void reverse(int []arr){
        for(int i=0;i<arr.length/2;i++){
            MyUtils.swap(arr,i,arr.length-i-1);
        }
    }

    //判断是否为素数  时间复杂度： O（sqrt(n)）
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }

        for(int i=2;i*i <=n;i++ ){
            if(n%i==0){
                return  false;
            }
        }

        return true;
    }

    //讨论递归方法和非递归方法的空间复杂度
    //非递归   空间复杂度 O（1）
    public static int sum1(int n){
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    //递归     空间复杂度 O（n）
    public static int sum2(int n){
        if(n==0){
            return 0;
        }
        return n+sum2(n-1);
    }

}
