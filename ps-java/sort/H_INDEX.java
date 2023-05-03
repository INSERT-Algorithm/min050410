// H-Index
// 예외: 인용된 논문이 h편 이상일 때를 판별했어야 했는데 h편과 같을 때를 판별했다.

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] integerCitations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integerCitations, ((o1, o2) -> (o2 - o1)));
        PriorityQueue<Integer> pq = new PriorityQueue<>();   
        for (int i=0; i<citations.length; i++) {
            pq.add(citations[i]);
        }
        int M = integerCitations[0];
        int s = citations.length;
        int cnt = 0;
        for (int i=0; i<=M; i++) {
            if (i > pq.peek()) {
                cnt++;
                pq.poll();
            }
            if (s - cnt >= i) answer = Math.max(answer, i);
        }
        return answer;
    }
}