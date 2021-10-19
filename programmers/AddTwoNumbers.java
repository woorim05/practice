import java.util.*;

// List 사용
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (list.size() != 0 && list.contains(sum)) continue;
                list.add(sum);
            }
        }
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
            answer[i] = list.get(i);
        
        return answer;
    }
}

// TreeSet 사용
class Solution {
    public Set<Integer> solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (set.size() != 0 && set.contains(sum)) continue;
                set.add(sum);
            }
        }

        return set;
    }
}
