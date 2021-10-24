/*
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
*/

class Solution {
    public String solution(String s) {
        String answer = "";
        int mid = s.length()/2;
        
        if (s.length() % 2 == 0)
            answer = s.substring(mid-1, mid+1);
        else
            answer = s.substring(mid, mid+1);
        
        return answer;
    }
}

class Solution {
    public String solution(String s) {
        return s.substring((s.length()-1) / 2, s.length()/2 + 1);
    }
}
