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
    //若一个数n能被2和√n之间的数整除（取余为0），则可判断n为素数。可从2开始测试，一直到√n为止。
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
    /*
    求质数的其他方法，筛法求质数：
    这种方法高效，但内存消耗较大。
    用筛法求素数的基本思想是：把从1开始的、某一范围内的正整数从小到大顺序排列， 1不是素数，首先把它筛掉。剩下的数中选择最小的数是素数，然后去掉它的倍数。依次类推，直到筛子为空时结束。
    * */

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


    //求次方  n>=0的情况
    //时间复杂度O（logn）
    public static double pow(double x,int n){
        if(n==0){
            return 1;
        }

        double t = pow(x,n/2);
        if(n%2>0){
            return x*t*t;
        }
        return t*t;
    }

    //求阶乘   递归调用
    public static int fact(int n){
        if(n==1){
            return 1;
        }else{
            return n*fact(n-1);
        }
    }

    /*
    在上面写的一般递归函数 func() 中，我们可以看到，func(n)  是依赖于 func(n-1) 的，func(n) 只有在得到 func(n-1) 的结果之后，
    才能计算它自己的返回值，因此理论上，在 func(n-1) 返回之前，func(n)，不能结束返回。因此func(n)就必须保留它在栈上的数据，
    直到func(n-1)先返回，而尾递归的实现则可以在编译器的帮助下，消除这个限制
    * */

    //求阶乘  使用尾递归  多加了个参数result
    //在main函数中这样调用  fact(100,1)
    public static int fact(int n,int result){
        if (n <= 1) return result;
        return fact(n - 1, n * result);
    }

}
