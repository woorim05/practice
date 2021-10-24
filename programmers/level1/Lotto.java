/*
민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어질 때,
당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
*/

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
