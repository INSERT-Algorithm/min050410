// 올바른 괄호
// 기초 stack 문제

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(1);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            
            
        }
        
        return stack.isEmpty();
    }
}