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
