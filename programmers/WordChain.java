import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> list = new ArrayList();
        
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) {
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }
            list.add(words[i]);
            
            if (i > 0) {
                String first = words[i].substring(0,1);
                String last = words[i-1].substring(words[i-1].length()-1);
                if (!first.equals(last)) {
                    answer[0] = (i%n) + 1;
                    answer[1] = (i/n) + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
