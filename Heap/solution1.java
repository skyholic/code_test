import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K) {
            
            if (queue.size() < 2) {
                return -1;
            }
            
            int firstSoville = queue.poll();
            int secondSoville = queue.poll();
            
            queue.add(firstSoville + (secondSoville * 2));
            answer += 1;
        }
        
        
        return answer;
    }
}