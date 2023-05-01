// 프로세스
// deque를 이용한 구현 문제

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cnt = 0;
        Deque<int []> dq = new ArrayDeque<>();
        int index = 0;
        for (int i: priorities) {
            int[] v = new int[2];
            v[0] = i;
            v[1] = index;
            dq.addLast(v);
            index++;
        }
        boolean isExcuted = true;
        
        while (!dq.isEmpty()) {
            int[] v = dq.getFirst();
            dq.remove();
            
            for (int[] e: dq) {
                if (v[0] < e[0]) {
                    dq.addLast(v);
                    isExcuted = false;
                    break;
                }
            }
            
            if (!isExcuted) {
                isExcuted = true;
                continue;
            }
            cnt++;
            if (v[1] == location) {
                answer = cnt;
                break;
            }
        }
        
        return answer;
    }
}