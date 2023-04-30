// 완주하지 못한 선수
// 개선 
// 1. getOrDefault 함수 이용
// 2. map.remove를 쓰지 않고 출력 부분에 조건 달기

import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p: participant) {
            if (!map.containsKey(p)) map.put(p, 1);
            else map.put(p, map.get(p)+1);
        }
        for (String c: completion) {
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        for (String i: map.keySet()) {
            answer = i;
        }
        return answer;
    }

}