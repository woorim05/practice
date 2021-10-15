class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
	int[] rank = {6,6,5,4,3,2,1};
	int min_score = 0;
	int unknown = 0;

	for (int i = 0; i < lottos.length; i++) {
	    if (lottos[i] == 0) unknown++;

	    for (int j = 0; j < win_nums.length; j++) {
		if (lottos[i] == win_nums[j]) {
		    min_score++;
		    break;
		}
	    }
	}

	answer[0] = rank[min_score + unknown];
	answer[1] = rank[min_score];

        return answer;
    }
}
