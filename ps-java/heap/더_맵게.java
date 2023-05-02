// 더 맵게
// 최소 힙의 첫번째 두번째 요소를 꺼내 푸는 문제

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s: scoville) {
            pq.add(s);
        }
        while (!pq.isEmpty()) {
            int temp = pq.peek();
            pq.poll();
            if (temp >= K) {
                break;
            }
            else {
                if (pq.isEmpty()) return -1;
                pq.add(temp + (pq.peek() * 2));
                pq.poll();
            }
            cnt++;
        }
        return cnt;
    }
}