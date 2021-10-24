/*
사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를
구해서 return 하도록 solution 함수를 완성해주세요.
*/
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> list = new ArrayList();
        
        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) { // 중복된 단어일 경우
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }
            list.add(words[i]);
            
            if (i > 0) { // 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 다를 경우
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
