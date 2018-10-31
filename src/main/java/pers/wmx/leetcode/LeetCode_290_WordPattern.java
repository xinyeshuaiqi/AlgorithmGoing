package pers.wmx.leetcode;

import java.util.*;

/**Given a pattern and a string str, find if str follows the same pattern.
 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Example 1:
 Input: pattern = "abba", str = "dog cat cat dog"
 Output: true

 Example 2:
 Input:pattern = "abba", str = "dog cat cat fish"
 Output: false

 Example 3:
 Input: pattern = "aaaa", str = "dog cat cat dog"
 Output: false

 Example 4:
 Input: pattern = "abba", str = "dog dog dog dog"
 Output: false

 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-31 16:07
 **/
public class LeetCode_290_WordPattern {

    //算法比只用一个map解决的要麻烦很多
    //我的思路：
    //把pattern和str都映射成一个List(根据List中元素的有序性就可以判断模式是否匹配)
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");

        int index1=0;
        List<Integer> record1 =new ArrayList<>();
        Map<Character,Integer> map1 =new HashMap<>();  //一个字符映射到一个数
        for (int i = 0; i < chars.length; i++) {
            if(!map1.containsKey(chars[i])){
                index1++;
                map1.put(chars[i],index1);
                record1.add(index1);
            }else{
                Integer temp = map1.get(chars[i]);
                record1.add(temp);
            }
        }

        int index2=0;
        List<Integer> record2 =new ArrayList<>();
        Map<String,Integer> map2 =new HashMap<>();  //一个字符串映射到一个数
        for (int i = 0; i < strs.length; i++) {
            if(!map2.containsKey(strs[i])){
                index2++;
                map2.put(strs[i],index2);
                record2.add(index2);
            }else{
                Integer temp = map2.get(strs[i]);
                record2.add(temp);
            }
        }

        if(record1.size()!= record2.size()){
            return false;
        }

        //遍历2个list是否相同
        for (int i = 0; i <record1.size() ; i++) {
            if(record1.get(i)!=record2.get(i)){
                return false;
            }
        }

        return true;
    }
}
