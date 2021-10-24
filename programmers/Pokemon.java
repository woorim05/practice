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
