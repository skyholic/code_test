import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int supoCount = 3;
		int[][] supo = new int[][] { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 },
				{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		int[] result = new int[supoCount];
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < supoCount; j++) {
                int answerIndex = i % supo[j].length;
				if (answers[i] == supo[j][answerIndex]) {
					result[j]++;
				}
			}
		}
        
        int max = Math.max(result[0], Math.max(result[1], result[2]));
        
        List<Integer> maxSupoList = new ArrayList<>();
        for (int i = 0; i < supoCount; i++) {
            if (result[i] == max) {
                maxSupoList.add(i);
            }
        }
        
        int[] answer = new int[maxSupoList.size()];
        for (int i = 0; i < maxSupoList.size(); i++) {
          answer[i] = maxSupoList.get(i) + 1;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}