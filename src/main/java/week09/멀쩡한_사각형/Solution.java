package week09.멀쩡한_사각형;

import java.math.BigInteger;

public class Solution {
    public long solution(int w, int h) {
        return ((long) w * h) - (w + h - gcd(w, h));
    }

    public int gcd(int x, int y) {
        return BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
    }
}
