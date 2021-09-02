import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        Iterator<Integer> iterator = map.values().iterator();
        while(iterator.hasNext()) {
            answer *= iterator.next().intValue() + 1;
        }
        
        return answer - 1;
    }
}