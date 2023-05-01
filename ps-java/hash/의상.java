// 의상
// 경우의 수 구하는 법 )
// 어떤 한 수의 약수의 개수를 구하는 과정과 동일하다.
// 1. hashMap에 중복 횟수를 더하며 저장한다.
// 2. hashMap의 value에 1을 더하고 모두 곱한다.
// -> 약수의 개수에서는 지수 + 1을 모두 곱하는 과정과 같음
// 3. 곱해진 수에 1을 뺀다.
// -> 약수의 개수에서는 1이 포함되었기 때문에 여기서는 경우의 수 1개를 빼줘야됨

// ex) 
// 바지 2개, 옷 2개, 모자 2개
// (2 + 1) * (2 + 1) * (2 + 1) = 21 
// 21 - 1 = 20
// 총 경우의 수는 20 

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (String[] c: clothes) {
            hm.put(c[1], hm.getOrDefault(c[1], 0) + 1);
        }
        
        
        for (Integer s: hm.values()) {
            answer = answer * (s + 1);
        }
        
        return answer - 1;
        
    }
    
}