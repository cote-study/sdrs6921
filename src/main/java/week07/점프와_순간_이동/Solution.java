package week07.점프와_순간_이동;


public class Solution {
    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            if (isOdd(n)) {
                answer++;
            }

            n /= 2;
        }

        return answer;
    }

    private boolean isOdd(final int n) {
        return n % 2 == 1;
    }
}
