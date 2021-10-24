/*
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록
solution 함수를 작성해주세요.
*/

import java.util.*;
 
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++)
            str[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(str, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        
        answer = sb.toString();
        
        return str[0].equals("0") ? "0" : answer;
    }
}
