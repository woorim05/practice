/*
1. 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현
3. 1은 생략
4. 자르고 마지막에 남는 문자열은 그대로 붙여줌
압축할 문자열 s가 매개변수로 주어질 때,
위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중
가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
*/

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++) {
            int count = 1;
            int sameCount = 0;
            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < s.length(); j+=i) {
                if (j+i*2 > s.length()) {
                    if (sameCount == 0) {
                        sb.delete(0, sb.length());
                    } else {
                        if (count == 1) sb.append(s.substring(j, s.length()));
                        else sb.append(count+s.substring(j, s.length()));
                    }
                    break;
                }
                
                if (s.substring(j, j+i).equals(s.substring(j+i, j+i*2))) {
                    count++;
                    sameCount++;
                } else {
                    if (count == 1) sb.append(s.substring(j, j+i));
                    else sb.append(count+s.substring(j, j+i));
                    count = 1;
                }
            }
            
            if (sb.length() != 0) answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
