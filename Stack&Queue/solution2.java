import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<TempQueue> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new TempQueue(i, priorities[i]));
        }
        
        while(!queue.isEmpty()) {
            TempQueue curPriority = queue.poll();
            boolean flag = false;
            
            for (TempQueue priority : queue) {
                if (priority.priority > curPriority.priority) {
                    flag = true;
                }
            }
            
            if (flag) {
                queue.add(curPriority);
            } else {
                answer += 1;
                if (curPriority.location == location) {
                    return answer;
                }
            }
        }
        
        return answer;
    }
    
    private class TempQueue {
        int location;
        int priority;
        
        public TempQueue(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    } 
}