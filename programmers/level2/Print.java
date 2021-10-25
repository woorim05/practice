/*
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
*/

import java.util.*;
import java.util.Map.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <인덱스, 중요도>
        Queue<Entry<Integer, Integer>> que = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) map.put(i, priorities[i]);
        for (Entry<Integer, Integer> m : map.entrySet()) que.add(m);
        
        int pollKey = -1;
        int maxValue = Collections.max(map.values());
        
        while (pollKey != location) {
            if (que.peek().getValue() < maxValue) {
                que.add(que.poll());
            
            } else {
                answer++;
                map.remove(que.peek().getKey());
            	pollKey = que.poll().getKey();
                if (que.isEmpty()) break;
                maxValue = Collections.max(map.values());
            }
        }
        
        return answer;
    }
}
