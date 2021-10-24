/*
놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서
얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.
*/
// for문, 삼항연산자 사용
class Solution {
    public long solution(int price, int money, int count) {
        long fee = 0;
        for (int i = 1; i <= count; i++) fee += i * price;
        return fee > money ? fee - money : 0;
    }
}

// 등차수열의 합 공식, Math함수 사용
class Solution {
    public long solution(long price, long money, long count) {
        long fee = price * (count * (count + 1) / 2);
        return Math.max(fee - money, 0);
    }
}
