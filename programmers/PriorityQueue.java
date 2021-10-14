import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scov : scoville) pq.add(scov);
        
        while (pq.peek() < K) {
            if(pq.size() == 1) {
                answer = -1;
                break;
            }
            int newScoville = pq.poll() + (pq.poll() * 2);
            pq.offer(newScoville);
            answer++;
        }
        
        return answer;
    }
}
