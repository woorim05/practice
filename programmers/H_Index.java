import java.util.*;

// 1차 시도 : 내림차순 정렬로 풀려고 함 => Integer로 바꿔주면서 속도가 느려짐
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = arr.length; i >= 0; i--) {
            if (arr[0] == 0) {
                answer = 0;
                break;
            }
            if (i <= arr[i-1]) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}

// 2차 시도 : 오름차순으로 풀이 + if문으로도 0번째 값이 0인 경우 answer에 0이 들어가서 불필요한 if문 제거
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    } 
}
