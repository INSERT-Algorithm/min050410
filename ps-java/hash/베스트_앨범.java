// 베스트 앨범 - 레벨 3
// qriorityQueue로 해결

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans = new ArrayList<>();
        // 인덱스 0: 장르 순위, 인덱스 1: 재생 횟수, 인덱스 2: 고유 번호
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]==b[0]?b[1]==a[1]?a[2]-b[2]:b[1]-a[1]:a[0]-b[0]));
        
        // 장르 순위를 구하는 맵
        HashMap<String, Integer> hm = new HashMap<>();
        
        // 장르 순위로 장르를 구하는 맵
        HashMap<Integer, String> hm2 = new HashMap<>();

        // pq에서 장르가 나온 횟수를 구하는 맵
        HashMap<String, Integer> hm3 = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
            hm2.put(plays[i], genres[i]);
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(((o1, o2) -> hm.get(o2.getKey()) - hm.get(o1.getKey())));
        
        int i = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            hm.put(entry.getKey(), i);
            hm2.put(i, entry.getKey());
            i++;
        }
        
        for (int j=0; j<genres.length; j++) {
            int[] a = {hm.get(genres[j]), plays[j], j};
            pq.add(a);
        }
        
        while (!pq.isEmpty()) {
            int[] data = pq.poll();
            String genre = hm2.get(data[0]);
            hm3.put(genre, hm3.getOrDefault(genre, 0)+1);
            // 최대 2개까지 허용
            if (hm3.get(genre) > 2) continue;
            ans.add(data[2]);
        }
        
        return ans.stream()
	        .mapToInt(Integer::intValue)
    	    .toArray();
    }
}