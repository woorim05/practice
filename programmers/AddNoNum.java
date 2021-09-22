class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += contain(numbers, i);
        }
        return answer;
    }
    
    public static int contain(int[] numbers, int input_data) {
        for (int num : numbers) {
            if (num == input_data)
                return 0;
        }
        return input_data;
   }
}
