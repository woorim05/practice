/*
숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가
매개변수로 주어질 때, s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
*/

class Solution { 
    public int solution(String s) {
        int answer = 0;
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(alphabet[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}
