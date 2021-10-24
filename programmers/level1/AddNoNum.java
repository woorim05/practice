/*
0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다.
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록
solution 함수를 완성해주세요.
*/

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
