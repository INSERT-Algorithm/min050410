// K번째수
// 정렬 기초 문제

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int t=0;
        for (int [] command: commands) {
            ArrayList<Integer> li = new ArrayList<>();
            for (int i=command[0]-1; i<command[1]; i++) {
                li.add(array[i]);
            }
            Collections.sort(li);
            answer[t] = li.get(command[2]-1);
            t++;
        }
        return answer;
    }
}