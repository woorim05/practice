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
        // 둘 다 정렬 필요
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]-1 || reserve[j] == lost[i]+1) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
    
        return answer;
    }
}
