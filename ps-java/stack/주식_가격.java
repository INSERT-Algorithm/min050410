// 주식 가격

// O(n^2) 해결방법도 있지만 Stack을 사용하면 더 효율적이게 짤 수 있다.
// 스택에 넣고 빼는 과정을 반복한다.
// 스택에서 빼면서 answer배열을 채워간다.

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            // prices[s.peek()]: 앞 시점, prices[i]: 현재 시점
            // 앞 시점이 현재 시점보다 클 때 while문 실행
            while (!s.isEmpty() && prices[s.peek()] > prices[i]) {
                // 현재 시점 - 앞 시점
                answer[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        
        // 구하지 않았던 나머지 답을 구함
        // 무조건 가격이 끝까지 안떨어지는 시점들
        while (!s.isEmpty()) {
            answer[s.peek()] = prices.length - s.peek() - 1;
            s.pop();
        }
        return answer;
    }
}