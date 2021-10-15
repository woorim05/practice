import java.util.*;

// 1차 시도 배열, 리스트 사용
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            days[i] = (int) Math.ceil((100-progresses[i]) / speeds[i]);
        }
        
        for (int i = 0; i < days.length; i++) {
            int count = 1;
            if (days[i] == 0) continue;
           
            for (int j = i+1; j < days.length; j++) {
                if (days[i] >= days[j]) {
                    count++;
                    days[j] = 0;
                } else break;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}


// 2차 시도 Queue 사용
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int days = (int) Math.ceil((100-progresses[i]) / (double) speeds[i]);
            
            if (!q.isEmpty() && q.peek() < days) {
                list.add(q.size());
                q.clear();
            }
                
            q.add(days);
        }
        
        list.add(q.size());

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
} 
