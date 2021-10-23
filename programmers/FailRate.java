import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Integer> all = new HashMap<>(); // <스테이지, 총 사용자>
        Map<Integer, Integer> fail = new HashMap<>();  // <스테이지, 실패한 사용자>
        Map<Integer, Double> failRate = new HashMap<>();  // <스테이지, 실패율>
        
        for (int i = 1; i <= N+1; i++) {
            all.put(i, 0);
            fail.put(i, 0);
        }
        
        for (int i = 0; i < stages.length; i++) {
            fail.replace(stages[i], fail.get(stages[i]) + 1);
            for (int j = 0; j < stages[i]; j++)
                all.replace(stages[i]-j, all.get(stages[i]-j) + 1);
        }        
                
        for (int i = 1; i <= N; i++) {
            if (fail.get(i) == 0 || all.get(i) == 0) failRate.put(i, (double) 0.0);
            else failRate.put(i, (double) fail.get(i)/all.get(i));
        }
                
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(failRate.entrySet());
        list.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        
        // list.sort(new Comparator<Map.Entry<Integer, Double>>() {
        //     @Override
        //     public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
        //         if (o1.getValue() > o2.getValue())
        //             return -1;
        //         else
        //             return 1;
        //     }
        // });
                
        int cnt = 0;
        for(Map.Entry<Integer, Double> entry : list){
            answer[cnt] = entry.getKey();
            cnt++;
        }
        
        
        return answer;
    }
}
