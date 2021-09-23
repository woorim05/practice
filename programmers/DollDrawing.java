import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> cart = new Stack<>();
        
        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                int popItem = board[i][m-1];
                
                if (popItem == 0) continue;
                
                if (cart.size() == 0 || popItem != cart.peek()) {
                    cart.push(board[i][m-1]);
                    board[i][m-1] = 0;
                    break;
                    
                } else if (popItem == cart.peek()) {
                    cart.pop();
                    board[i][m-1] = 0;
                    answer += 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}
