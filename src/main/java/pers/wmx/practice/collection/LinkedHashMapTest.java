package pers.wmx.practice.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wmx
 * @date 2019-12-26
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        //true是表示按照访问时间排序
        Map<Integer,Integer> map =
                new LinkedHashMap<>(10, 0.75f, true);
        map.put(1,1);
        map.put(2,3);
        map.put(5,2);
        map.put(9,4);
        map.put(3,7);

        //1 2 5 9 3
        map.entrySet().forEach(e-> System.out.print(e.getKey()+" "));
        System.out.println();

        map.put(1,11);
        map.get(5);

        //2 9 3 1 5
        map.entrySet().forEach(e-> System.out.print(e.getKey()+" "));
        System.out.println();
    }
}
