import java.util.*;

// 배열 복사
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[][] temp = new int[sizes.length][2];

        for(int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                temp[i][0] = sizes[i][1];
                temp[i][1] = sizes[i][0];
            } else {
                temp[i][0] = sizes[i][0];
                temp[i][1] = sizes[i][1];
            }  
        }

        int w = temp[0][0];
        int h = temp[0][1];

        for (int i = 0; i < temp.length; i++) {
            if (w < temp[i][0]) w = temp[i][0];
            if (h < temp[i][1]) h = temp[i][1];
        }

        answer = w*h;

        return answer;
    }
}

// Math함수 사용
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        
        for(int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            w = Math.max(max, w);
            h = Math.max(min, h);
        }
        
        answer = w * h;
        
        return answer;
    }
}
