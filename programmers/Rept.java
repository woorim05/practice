class Solution {
    public StringBuffer solution(int n) {
        StringBuffer answer = new StringBuffer();
        
        for (int i = 0; i < n; i++)
            if (i % 2 == 0) answer.append("수");
            else answer.append("박");
        
        return answer;
    }
}
