/*
 N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
 N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.*;

// HashSet 사용
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        
        answer = set.size() > nums.length/2 ? nums.length/2 : set.size();
        
        return answer;
    }
}

// List 사용
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            (!list.contains(nums[i])) list.add(nums[i]);
        }

        if (list.size() > nums.length/2) answer = nums.length/2;
        else answer = list.size();

        return answer;
    }
}
