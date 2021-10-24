class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3]; // 점수
        int[] bonus = new int[3]; // 보너스
        int[] option = {1, 1, 1}; // 옵션
        int s = 0, b = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (ch == 49 && dartResult.charAt(i+1) == 48) { // 점수가 10일 때
                score[s] = Integer.parseInt(dartResult.substring(i, i+2));
                s++; i++;
            } else {
                if (48 <= ch && ch <= 57) { // 숫자
                    score[s] = ch - '0';
                    s++;
                } else if (ch == 83) { // S
                    bonus[b] = 1;
                    b++;
                } else if (ch == 68) { // D
                    bonus[b] = 2;
                    b++;
                } else if (ch == 84) { // T
                    bonus[b] = 3;
                    b++;
                } else if (ch == 42) { // *
                    if (b == 1) option[0] *= 2;
                    else {
                        option[b-1] *= 2;
                        option[b-2] *= 2;
                    }
                } else if (ch == 35) { // #
                    option[b-1] *= -1; 
                }
            }
        }
        
        for (int i = 0; i < 3; i++) {
            score[i] = (int) Math.pow(score[i], bonus[i]) * option[i];
        }
        
        answer = score[0] + score[1] + score[2];
        
        return answer;
    }
}
