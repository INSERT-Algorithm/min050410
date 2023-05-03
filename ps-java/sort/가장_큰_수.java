// 1. 첫번째로 푼 풀이 시간초과
// 브루트 포스로 구현하면 시간 초과가 걸린다.

import java.util.*;

class Solution {
    
    private ArrayList<String> li = new ArrayList<>();
    private int [] number = new int[100000];
    private boolean [] visited = new boolean[100000];
    int s;
    
    public String solution(int[] numbers) {
        s = numbers.length;
        res(0, numbers);
        Collections.sort(li, Collections.reverseOrder());
        String answer = li.get(0);
        return answer;
    }
    
    private void res(int x, int[] numbers) {
        if (x == s) {
            String n = "";
            for (int i=0; i<s; i++) {
                n += Integer.toString(number[i]);
            }
            li.add(n);
            return;
        }
        for (int i=0; i<s; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            number[x] = numbers[i];
            res(x+1, numbers);
            visited[i] = false;
        }
    }
}

// 2. 두번째로 푼 풀이 AC
// 정렬 조건을 지정해서 해결했다.
// compare 매서드를 override해서 구현했다.

import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) strNumbers[i] = Integer.toString(numbers[i]);
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split("");
                String[] arr2 = o2.split("");
                int p1 = 0;
                int p2 = 0;
                while (Integer.parseInt(arr1[p1]) == Integer.parseInt(arr2[p2])) {
                    if (p1 == arr1.length - 1 && p2 == arr2.length - 1) break;
                    if (p1 < arr1.length - 1) p1++;
                    if (p2 < arr2.length - 1) p2++;
                } 
                if (p1 < p2) {
                    int j = 0;      
                    while (Integer.parseInt(arr1[j]) == Integer.parseInt(arr2[p2])) {
                        if (j == arr1.length - 1) break;
                        j++;
                    }
                    return Integer.parseInt(arr2[p2]) - Integer.parseInt(arr1[j]);
                }
                if (p2 < p1) {
                    int j = 0;
                    while (Integer.parseInt(arr2[j]) == Integer.parseInt(arr1[p1])) {
                        if (j == arr2.length - 1) break;
                        j++;
                    }
                    return Integer.parseInt(arr2[j]) - Integer.parseInt(arr1[p1]);
                }
                return Integer.parseInt(arr2[p2]) - Integer.parseInt(arr1[p1]);
            }
        });
        String answer = "";
        boolean isZero = true;
        for (String s: strNumbers) {
            answer += s;
            if (Integer.parseInt(s) != 0) isZero = false;
        }
        if (isZero) return "0";
        return answer;
    }

}

