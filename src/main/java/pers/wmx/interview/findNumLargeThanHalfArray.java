package pers.wmx.interview;

/**
 * 数组中一定有一个元素超过数组大小的一半
 *
 * @author wmx
 * @date 2020-02-11
 */
public class findNumLargeThanHalfArray {

    //4 2 2 2 2 1 5
    //2的个数大于数组大小的一半
    public static int findNum(int arr[]){
        CountNum countNum = new CountNum();
        countNum.num = arr[0];
        countNum.count = 1;

        for (int i = 1; i < arr.length; i++) {
            if(countNum.num != -1 && arr[i] !=  countNum.num){
                if(countNum.count == 1){
                    //表示前面遍历的数据都一一抵消了
                    countNum.num = -1;
                }
                //num不变，说明num还未全被抵消，比如有已经遍历了3个2，才被抵消一个2
                countNum.count --;
            }else{
                countNum.num = arr[i];
                countNum.count ++;
            }
        }

        //最终幸存者
        return countNum.num;

    }

    public static void main(String[] args) {
        int arr[] = {4,2,2,2,2,1,5};
        int num = findNum(arr);
        System.out.println(num);
    }
}

class CountNum{
    int num;
    int count;
}
