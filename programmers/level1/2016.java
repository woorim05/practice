/*
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
*/
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
