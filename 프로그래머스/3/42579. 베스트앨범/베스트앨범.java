import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, List<int[]>> map = new HashMap<>(); 
        
        Map<String, Integer> total = new HashMap<>();        
        
        for(int i = 0; i < plays.length; i++){
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }

            map.get(genres[i]).add(new int[]{i, plays[i]});
            
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> genreList = new ArrayList<>(total.keySet());
        genreList.sort((a, b) -> total.get(b) - total.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String gen : genreList) {
            List<int[]> arr = map.get(gen);

            arr.sort((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return a[0] - b[0];
            });

            result.add(arr.get(0)[0]);

            if (arr.size() > 1) {
                result.add(arr.get(1)[0]);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}