/*
각 판매원의 이름을 담은 배열 enroll,
각 판매원을 다단계 조직에 참여시킨 다른 판매원의 이름을 담은 배열 referral,
판매량 집계 데이터의 판매원 이름을 나열한 배열 seller,
판매량 집계 데이터의 판매 수량을 나열한 배열 amount가 매개변수로 주어질 때,
각 판매원이 득한 이익금을 나열한 배열을 return 하도록 solution 함수를 완성해주세요.
판매원에게 배분된 이익금의 총합을 계산하여(정수형으로),
입력으로 주어진 enroll에 이름이 포함된 순서에 따라 나열하면 됩니다.
*/
import java.util.*;
// 이름을 기준으로 수익과 추천인을 맵에 담고 계산 후 정답 배열에 담아줌
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> hm = new HashMap<>(); // <이름, 수익>
        HashMap<String, String> ref = new HashMap<>(); // <이름, 추천인>
        
        for (int i = 0; i < enroll.length; i++) {
            hm.put(enroll[i], 0);
            ref.put(enroll[i], referral[i]);
        } 
        
        for (int i = 0; i < seller.length; i++) {
            String emp = seller[i];
            int money = amount[i] * 100;
            
            while (!emp.equals("-")) {
                hm.replace(emp, hm.get(emp)+money-money/10);
                emp = ref.get(emp);
                money /= 10;
                if (money == 0) break;
            }
        }
        
        for(int i=0; i<enroll.length; i++){
            answer[i] = hm.get(enroll[i]);
        }
        
        return answer;
    }
}

// enroll배열을 리스트화한 후 indexOf로 추천인 index 구함 => 효율성 완전 떨어짐
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        List<String> enrollList = Arrays.asList(enroll);
        
        for (int i = 0; i < seller.length; i++) {
            String emp = seller[i];
            int money = amount[i] * 100;
            int index = enrollList.indexOf(emp);
            
            while (true) {
                answer[index] += money - (money / 10);
                emp = referral[index];
                money /= 10;
                index = enrollList.indexOf(emp);
                if (money == 0 || index == -1) break;
            }
            
        }
        
        return answer;
    }
}

// 위와 같은 방법이지만 인덱스를 맵에 담아줌 => 가장 효율성 좋은 방법!!
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) hm.put(enroll[i], i);
        
        for (int i = 0; i < seller.length; i++) {
            String emp = seller[i];
            int money = amount[i] * 100;
            int index = hm.get(emp);
            
            while (true) {
                answer[index] += money - (money / 10);
                emp = referral[index];
                money /= 10;
                if (money == 0 || emp.equals("-")) break;
                index = hm.get(emp);
            }
            
        }
        
        return answer;
    }
}
