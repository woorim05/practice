/*
전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
(체육복은 자기 번호의 앞, 뒤 번호인 사람에게만 빌려줄 수 있음)
*/

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        // 해시는 순서를 갖지 않기 때문에 reserve 정렬 안해도 됨
        Arrays.sort(lost);
        
        HashSet<Integer> hs = new HashSet<>();
        for (int r : reserve) hs.add(r);
        
        for (int i = 0; i < lost.length; i++) {
            if (hs.contains(lost[i])) {
                hs.remove(lost[i]);
                lost[i] = -1;
                answer++;
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            if (hs.contains(lost[i]-1)) {
                hs.remove(lost[i]-1);
                answer++;
            
            } else if (hs.contains(lost[i]+1)) {
                hs.remove(lost[i]+1);
                answer++;
            }
        }
    
        return answer;
    }
}
