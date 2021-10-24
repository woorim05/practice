/*
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 
완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>(); // <선수 이름, 선수 수>

        // 참여한 선수 동명이인일 경우 value +1
        for (String player : participant)
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        
        // 완주한 선수 수 -1 => 완주하면 0이 됨
        for (String player : completion)
            hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }
}
