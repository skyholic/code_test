import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for(String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }
        
        for(String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return answer;
    }
}