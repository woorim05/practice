/*
다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
(1초에 한 칸(1만큼) 갈 수 있음)
이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
*/

import java.util.*;

public class TruckCrossingBridge {
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_wights = {10,10,10,10,10,10,10,10,10,10};
      
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_wights = {7,4,5,6};
      
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_wights = {10};
        System.out.println("answer = " + solution(bridge_length, weight, truck_wights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> before = new LinkedList<>();
        Queue<Integer> ing = new LinkedList<>();
        Queue<Integer> after = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            before.add(truck_weights[i]);
        }

        int index = 0;
        int current_weight = 0;
        
        while (after.size() < truck_weights.length) {
            answer++;
            
            if (!ing.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i)+1);
                }
                
                if (list.get(0) == bridge_length+1) {
                    list.remove(0);
                    index--;
                    after.add(ing.peek());
                    current_weight -= ing.poll();
                }
            }

            if (!before.isEmpty()) {
                if (current_weight+before.peek() > weight) {
                    continue;
                } else {
                    list.add(index, 1);
                    index++;
                    ing.add(before.peek());
                    current_weight += before.poll();
                }
            }

        }

        return answer;
    }
}
