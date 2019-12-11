package pers.wmx.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 斐波那契数列  f(n) = f(n-1)+f(n-2)
 *
 * 斐波那契数列是根据兔子的繁殖得到的一组数列：
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,89, 144, 233....
 * 其特点是从第三项开始每一项都等于前两项之和。
 *
 * @author: wangmingxin1
 * @create: 2018-10-26 10:42
 **/
public class FibonacciSequence {

    //递归法
    public static int fib1(int n){
        if(n<=0) {
            return 0;
        }
        if (n ==1) {
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    //非递归   消除重复计算
    public static int fib2(int n)
    {
        int []fib=new int[50];
        fib[0]=1;
        fib[1]=1;
        for(int i=2;i<=n;i++)
        {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
    }


    //记忆搜索法
    public static int fib3(int n)
    {
        int[] record = new int[n+1];
        Arrays.fill(record,-1);
        return fib(n,record);
    }

    private static int fib(int n, int[] record) {
       if(n==0){
           return 0;
       }
       if(n==1){
           return 1;
       }

       if(record[n]!=-1){
           return record[n];
       }

        for (int i = 2; i < n+1 ; i++) {
            record[i] = fib(i - 1, record) + fib(i - 2, record);
        }

        return record[n];

    }

    @Test
    public void test(){
        System.out.println(fib3(0));
        System.out.println(fib3(1));
        System.out.println(fib3(2));
        System.out.println(fib3(3));
        System.out.println(fib3(4));
        System.out.println(fib3(5));
    }
}
