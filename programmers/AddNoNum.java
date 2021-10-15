// 숫자가 있으면 0 리턴, 없으면 없는 숫자 리턴
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

// 있는 숫자를 0~9의 합인 45에서 빼줌
class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int i : numbers) {
            answer -= i;
        }
        return answer;
    }
}
