// 이중 우선순위 큐

// 1. minPq와 maxPq에 모든 값과 고유번호 index를 넣는다.
// 2. 처음 최댓값 또는 최솟값 제거시 minPq의 top에서 하나를 뺀다. 빼는 과정에서 뺀 고유번호를 blackList에 추가한다.
// 3. 다음 최댓값 최솟값 제거시 top이 blackList라면 무시하고 blackList가 아닌 top이 나올 때까지 반복 후 나오면 pq에서 제거한다.
// 빼는 과정에서 뺀 고유번호를 blackList에 마찬가지로 추가한다.
// 4. 마지막에 minPq와 maxPq를 조회해 blackList는 무시하고 최댓값과 최솟값을 뽑는다.

// 값을 뺄 때 remove를 사용해 날먹을 할 수 있지만 HashMap(BlackList)를 사용해 성능을 더 올렸다.
// remove로 특정 원소 제거: 최악 O(NLogN)
// blackList HashMap 참조: 최악 O(N)

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<int []> minPq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        PriorityQueue<int []> maxPq = new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));
        HashMap<Integer, Boolean> blackList = new HashMap<>();
        int i = 0;
        
        for (String oper: operations) {
            int k = Integer.parseInt(oper.substring(2));
            if (oper.charAt(0) == 'I') {
                minPq.add(new int[] {k, i});
                maxPq.add(new int[] {k, i});
                blackList.put(i, false);
                i++;
            }
            if (oper.charAt(0) == 'D') {
                if (k == 1) {
                    while (!maxPq.isEmpty() && blackList.get(maxPq.peek()[1])) {
                        maxPq.poll();
                    }
                    if (maxPq.isEmpty()) continue;
                    int[] M = maxPq.peek();
                    blackList.put(M[1], true);
                    maxPq.poll();
                }
                if (k == -1) {
                    while (!minPq.isEmpty() && blackList.get(minPq.peek()[1])) {
                        minPq.poll();
                    }
                    if (minPq.isEmpty()) continue;
                    int[] m = minPq.peek();
                    blackList.put(m[1], true);
                    minPq.poll();
                }
            }
        }
       
        while (!maxPq.isEmpty()) {
            if (!blackList.get(maxPq.peek()[1])) {
                answer[0] = maxPq.peek()[0];
                break;
            }
            maxPq.poll();
        }
        
        while (!minPq.isEmpty()) {
            if (!blackList.get(minPq.peek()[1])) {
                answer[1] = minPq.peek()[0];
                break;
            }
            minPq.poll();
        }
         
        return answer;
    }
}