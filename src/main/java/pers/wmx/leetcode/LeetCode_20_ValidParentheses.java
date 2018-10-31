package pers.wmx.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:
 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:
 Input: "()"
 Output: true

 Example 2:
 Input: "()[]{}"
 Output: true

 Example 3:
 Input: "(]"
 Output: false

 Example 4:
 Input: "([)]"
 Output: false

 Example 5:
 Input: "{[]}"
 Output: true
 *
 *
 * @author: wangmingxin1
 * @create: 2018-10-31 15:36
 **/
public class LeetCode_20_ValidParentheses {

    //括号匹配  利用栈
    public boolean isValid(String s) {
        if(s==null || "".equals(s.trim())){
            return true;
        }

        Stack stack =new Stack();
        char[] chars = s.toCharArray();

        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
                continue;
            }

            if(stack.empty()){
                return false;
            }

            char top = (char) stack.peek();  //从栈顶取元素
            char match = 0;    //和栈顶元素应该匹配的值

            if(top == '('){
                match=')';
            }else if(top == '['){
                match=']';
            }else if(top == '{'){
                match='}';
            }

            if(chars[i] == match){
                stack.pop();  //括号匹配 ----> 弹出栈顶元素
            }else{            //不匹配 压栈
                stack.push(chars[i]);
            }

        }

        if(stack.empty()){
            return true;
        }

        return false;
    }

    @Test
    public void test(){
        String s="()";
        System.out.println(isValid(s));
    }
}
