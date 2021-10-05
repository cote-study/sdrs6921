package week11.디스크_컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    private static final int START_TIME = 0;
    private static final int END_TIME = 1;

    public int solution(int[][] jobs) {
        int answer = 0;
        int endOfTime = 0;
        int jobIndex = 0;
        int numberOfJobsProcessed = 0;

        Arrays.sort(jobs, Comparator.comparingInt(job -> job[START_TIME]));
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job[END_TIME]));

        while (numberOfJobsProcessed < jobs.length) {

            while (jobIndex < jobs.length && jobs[jobIndex][0] <= endOfTime) {
                pq.offer(jobs[jobIndex++]);
            }

            if (pq.isEmpty()) {
                endOfTime = jobs[jobIndex][START_TIME];
                continue;
            }

            int[] processedJob = pq.poll();
            endOfTime += processedJob[END_TIME];
            answer += endOfTime - processedJob[START_TIME];
            numberOfJobsProcessed++;
        }

        return answer / jobs.length;
    }
}
