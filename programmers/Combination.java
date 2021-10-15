import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (String[] str : clothes)
            hm.put(str[1], hm.getOrDefault(str[1], 0) + 1);

        for (Entry<String, Integer> entry : hm.entrySet()) 
            answer *= entry.getValue() + 1;

        answer--; // 모두 사용하지 않을 경우 제거

        return answer;
    }
}
