/*
음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록
solution 함수를 작성해주세요.
*/

import java.util.*;

// 우선순위 큐를 사용하여 자동정렬(오름차순) 후 poll()
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
