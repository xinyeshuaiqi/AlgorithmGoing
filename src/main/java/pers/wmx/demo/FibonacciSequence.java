package pers.wmx.demo;

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
        if(n<=0)
            return  0;
        if (n ==1)
            return 1;
        return fib1(n-1) + fib1(n-2);
    }

    //非递归
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

}
