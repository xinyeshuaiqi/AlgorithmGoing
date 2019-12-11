package pers.wmx.practice.digui;

/**
 * 走楼梯要么走一层，要么走两层
 * 一共走floor层有多少种方法？
 *
 * @author wmx
 * @date 2019-12-06
 */
public class LadderTest {
    //floor 表示走完多少层
    public static int ways(int floor){
        if(floor == 1){
            return 1;
        }

        if(floor == 2){
            return 2;
        }

        return ways(floor-1) + ways(floor-2);
    }

    public static void main(String[] args) {
        System.out.println(ways(1));
        System.out.println(ways(2));
        System.out.println(ways(3));
        System.out.println(ways(4));
        System.out.println(ways(5));
        System.out.println(ways(6));
    }

}
