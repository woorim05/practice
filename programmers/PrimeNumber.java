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

        for (int i = 2; i < num; i++) {
            if (num%i == 0) {
                prime = false;
                break;
            }
        }

        return prime;
    }
}
