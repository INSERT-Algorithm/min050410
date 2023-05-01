// 기능 개발 
// 남은 일자를 미리 구하고 전 작업의 남은 일자와 비교해 기능 배포수를 구함

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> li = new ArrayList<>();
        int release = 0;
        boolean isReleased = true;
        int before = 101;
        for (int i=0; i<speeds.length; i++) {
            // 남은 일자 구하기
            int lastDays = getLastDays(progresses, speeds, i);
            // 전 작업과 현 작업의 남을 일자 비교
            if (before < lastDays) {
                li.add(release);
                release = 0;
                isReleased = true;
            }
            if (isReleased) {
                before = lastDays;
                isReleased = false;
            }
            release++;
        }
        li.add(release);

        return li.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int getLastDays(int[] progresses, int[] speeds, int i) {
        int dividedDays = ((100 - progresses[i])/speeds[i]);
        return ((100 - progresses[i])%speeds[i] != 0) ? dividedDays+1 : dividedDays;
    }
    
}