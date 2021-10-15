import java.lang.*;

// 거듭제곱 메서드 생성
class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        
        // 3진법의 앞뒤 반전
        while (n > 0) {
            temp += n%3;
            n = n/3;
        }
        
        int j = temp.length()-1;
        for (int i = 0; i < temp.length(); i++) {
            answer += (temp.charAt(i)-'0') * calculatePower(j);
            j--;
        }
        
        return answer;
    }
    
    // 3의 거듭제곱
    public int calculatePower(int pow) {
        if (pow == 0)
            return 1;
        else
            return 3 * calculatePower(pow-1);
    }
}

// Math.pow 사용
class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        
        // 3진법의 앞뒤 반전
        while (n > 0) {
            temp += n%3;
            n = n/3;
        }
        
        int j = temp.length()-1;
        for (int i = 0; i < temp.length(); i++) {
            answer += (temp.charAt(i)-'0') * Math.pow(3, j);
            j--;
        }
        
        return answer;
    }
}

// parseInt 사용
class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        
        // 3진법의 앞뒤 반전
        while (n > 0) {
            temp += n%3;
            n = n/3;
        }
         
        answer = Integer.parseInt(temp, 3);
        
        return answer;
    }
}
