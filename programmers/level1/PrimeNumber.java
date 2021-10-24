/*
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를
return 하도록 solution 함수를 완성해주세요.
*/

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];

                    if (primeNum(num) == true) {
                        answer++;
                        continue;
                    }
                }
            }
        }

        return answer;
    }

    public boolean primeNum(int num) {
        boolean prime = true;
        
        // 1과 자기 자신을 제외한 수로 나누었을 때 나머지가 0이면 소수가 아니라는 의미
        for (int i = 2; i < num; i++) { 
            if (num%i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
