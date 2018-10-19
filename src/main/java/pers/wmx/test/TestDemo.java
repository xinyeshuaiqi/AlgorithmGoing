package pers.wmx.test;

import org.junit.jupiter.api.Test;
import pers.wmx.demo.SimpleDemo;

/**
 * @author: wangmingxin1
 * @create: 2018-10-19 18:16
 **/
public class TestDemo {
    @Test
    public void testReverse(){
        int []arr1 ={1,2,3,4,5,6};      //测试偶数个
        int []arr2 ={1,2,3,4,5,6,7};    //测试奇数个

        SimpleDemo.reverse(arr1);
        SimpleDemo.reverse(arr2);

        for(int num :arr1){
            System.out.print(num+" ");
        }
        System.out.println();

        for(int num :arr2){
            System.out.print(num+" ");
        }
        System.out.println();

    }
}
