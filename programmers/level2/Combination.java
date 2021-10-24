/*
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때,
서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
*/

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
