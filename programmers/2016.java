class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] date = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = b;
        
        for (int i = 0; i < a; i++) days += month[i];
        answer = date[days % 7];
        
        return answer;
    }
}
