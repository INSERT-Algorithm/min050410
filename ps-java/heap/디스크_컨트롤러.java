// 디스크 컨트롤러

// 어려웠던 점:
// 1. 처음엔 min pq, max pq두개를 써서 하려고 했으나, min pq를 처음 정렬 한번으로 대체할 수 있다는 것을 깨달았다.
// 2. 시간을 하나 하나 증가하며 minPq에 넣을지 말지 판단하는 로직을 생각하기 힘들었다. -> two pointer 알고리즘에서 pointer와 비슷했다.
// 다음에도 스케줄링 문제가 나오면 먼저 시간을 기준으로 잡고 시간을 1씩 증가시키는 사고력을 길러야겠다.
// 3. 아래와 같이 while 문으로 모든 작업이 완료될때까지 반복하는 트릭도 잘 배워야 될듯하다.

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int total = 0;
        PriorityQueue<int []> minPq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        
        int i = 0;
        int start = -1;
        int now = 0;
        while (i < jobs.length) {
            for (int j=0; j < jobs.length; j++) {
                if (start < jobs[j][0] && jobs[j][0] <= now) minPq.add(jobs[j]);
            } 
            if (!minPq.isEmpty()) {
                int[] temp = minPq.peek();
                minPq.poll();
                start = now;
                now += temp[1];
                answer += now - temp[0];
                i++;
            } else now++;
        }
        return answer / jobs.length;
    }
}