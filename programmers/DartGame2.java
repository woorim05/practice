class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int s = 0;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (ch == '1' && dartResult.charAt(i+1) == '0') {
                score[s] = 10;
                i++;
            } else {
                if (Character.isDisit(ch)) 
                    score[s] = ch - '0';
                else if (ch == 'S')
                    s++;
                else if (ch == 'D') {
                    score[s] = (int) Math.pow(score[s], 2);
                    s++;
                } else if (ch == 'T') {
                    score[s] = (int) Math.pow(score[s], 3);
                    s++;
                } else if (ch == '*') {
                    if (s == 1) score[0] *= 2;
                    else {
                        score[s-1] *= 2;
                        score[s-2] *= 2;
                    }
                } else if (ch == '#') {
                    score[s-1] *= -1; 
                }
            }
        }
                
        answer = score[0] + score[1] + score[2];
        
        return answer;
    }
}
