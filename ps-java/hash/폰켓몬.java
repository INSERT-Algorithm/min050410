// 폰켓몬

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        if (s.size() < nums.length / 2) return s.size();
        else return nums.length / 2;
    }
}