package pers.wmx.practice.search;

/**
 * @author wmx
 * @date 2019-12-11
 */
public class MyBinarySearch {

    //普通二分查找
    public static int search(int[] a, int n, int target){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(a[mid] < target){
                low = mid + 1;
            }else if(a[mid] > target){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //查找第一个等于的
    public static int searchFirstEqual(int[] a, int n, int target){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(a[mid] < target){
                low = mid + 1;
            }else if(a[mid] > target){
                high = mid - 1;
            }else {
                //如果mid已经到0了或者mid前面没有等于目标值得
                if(mid == 0 || a[mid-1]!=target){
                    return mid;
                }else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }

    //查找最后一个等于的
    public static int searchLastEqual(int[] a, int n, int target){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(a[mid] < target){
                low = mid + 1;
            }else if(a[mid] > target){
                high = mid - 1;
            }else {
                //如果mid已经到n-1了或者mid后面没有等于目标值得
                if(mid == n-1 || a[mid+1]!=target){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //查找第一个大于等于的
    public static int searchFirstLarge(int[] a, int n, int target){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(a[mid] < target){
                low = mid + 1;
            }else {
                if(mid == 0 || a[mid-1] < target){
                    return  mid;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    //查找最后一个小于等于的
    public static int searchLastSmall(int[] a, int n, int target){
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(a[mid] > target){
                high = mid - 1;
            }else {
                if(mid == n-1 || a[mid+1] > target){
                    return  mid;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,11,13};
        System.out.println(search(a,a.length,9));


        int[] a1 = {1,3,5,7,9,9,9,9,11,13};
        System.out.println(searchFirstEqual(a1,10,9));  //4
        System.out.println(searchLastEqual(a1,10,9));   //7
        System.out.println(searchFirstLarge(a1,10,9));  //4
        System.out.println(searchLastSmall(a1,10,9));   //7
    }

}
