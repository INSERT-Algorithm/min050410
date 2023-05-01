// 같은 숫자는 싫어
// stack을 사용해 풀이

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        for (int a: arr) {
            if (!s.isEmpty()) {
                if (s.peek() == a) continue;
            }
            s.push(a);
        }
        int[] answer = new int[s.size()];
        int i = 0;
        for (int ans: s) {
            answer[i] = ans;
            i++;
        }
        return answer;
    }
}