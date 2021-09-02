import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day += 1;
            }
            
            queue.add(day);
        }
        
        int prevProgress = queue.poll();
        int numOfProgress = 1;
        while(!queue.isEmpty()) {
            int curProgress = queue.poll();
            if (prevProgress >= curProgress) {
                numOfProgress += 1;
            } else {
                prevProgress = curProgress;
                answer.add(numOfProgress);
                numOfProgress = 1;
            }
        }
        answer.add(numOfProgress);
        
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}