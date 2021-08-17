package week07.입국심사;

import java.util.Arrays;

public class Solution {

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long begin = times[0];
        long end = (long) times[times.length - 1] * n;

        while (begin <= end) {
            long mid = (begin + end) / 2;
            long sum = Arrays.stream(times)
                    .mapToLong(time -> mid / time)
                    .sum();

            if (sum >= n) {
                end = mid - 1;
                answer = mid;
                continue;
            }

            begin = mid + 1;
        }

        return answer;
    }

}
