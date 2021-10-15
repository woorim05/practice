class Solution {
    int[][] dial = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,1},{3,2}};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lHand = 10;
        int rHand = 12;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                lHand = numbers[i];
            
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                rHand = numbers[i];
            
            } else {
                int lLength = distance(numbers[i], lHand); // 왼손 거리
                int rLength = distance(numbers[i], rHand); // 오른손 거리
                
                if (lLength < rLength) {
                    answer += "L";
                    lHand = numbers[i];
                
                } else if (lLength > rLength) {
                    answer += "R";
                    rHand = numbers[i];
                
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        lHand = numbers[i];
                    } else {
                        answer += "R";
                        rHand = numbers[i];
                    }   
                }
            }
        }
        
        return answer;
    }
    
    public int distance(int numbers, int position) {
        int x = Math.abs((dial[position][0]) - (dial[numbers][0]));
        int y = Math.abs((dial[position][1]) - (dial[numbers][1]));
        return (x + y); 
    }
}
