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
