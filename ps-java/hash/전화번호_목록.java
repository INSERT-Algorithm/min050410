// 전화번호 목록
// O(n^2)로는 통과가 안됨 sort를 사용해 O(logN + n)으로 변경

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}