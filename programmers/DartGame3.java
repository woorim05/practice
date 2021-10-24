import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if ('0' <= ch && ch <= '9') {
                if (ch == '1' && dartResult.charAt(i+1) == '0') {
                    stack.push(10);
                    i++;
                } else
                    stack.push(ch - '0');
            } else {
                int pop = stack.pop();
                if (ch == 'D') pop = (int) Math.pow(pop, 2);
                else if (ch == 'T') pop = (int) Math.pow(pop, 3);
                else if (ch == '#') pop *= -1;
                else if (ch == '*') {
                    if (!stack.isEmpty()) {
                        int prev = stack.pop() * 2;
                        stack.push(prev);
                    }
                    pop *= 2;
                }  
                stack.push(pop);
            }
        }
        
        while (!stack.isEmpty())
            answer += stack.pop();
        
        return answer;
    }
}
