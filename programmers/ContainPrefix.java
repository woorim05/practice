import java.util.*;
import java.util.Map.*;

// 1차 시도 HashMap 사용
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (String pb : phone_book) {
            hm.put(pb, pb.length());
        }
        
        for(String pb : phone_book) {
            for (int i = 1; i < pb.length(); i++) {
                if (hm.containsKey(pb.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}

// 2차 시도 HashSet 사용
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> hs = new HashSet<>();
        
        for (String pb : phone_book) {
            hs.add(pb);
        }
        
        for(String set : hs){
            for(int i = 1; i < set.length(); i++){
                if(hs.contains(set.substring(0, i))){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}

// 효율적인 측면에서 value가 없어도 HashMap 사용하는게 더 빠름
