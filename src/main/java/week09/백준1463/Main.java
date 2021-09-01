package week09.백준1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        bw.write(dynamicProgramming() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dynamicProgramming() {
        for (int i = 1; i <= N; i++) {
            if (shouldChangeValue(i * 3, i)) {
                dp[i * 3] = dp[i] + 1;
            }

            if (shouldChangeValue(i * 2, i)) {
                dp[i * 2] = dp[i] + 1;
            }

            if (shouldChangeValue(i + 1, i)) {
                dp[i + 1] = dp[i] + 1;
            }
        }
        return dp[N];
    }

    private static boolean shouldChangeValue(final int next, final int current) {
        return next <= N && (dp[next] == 0 || dp[next] > dp[current] + 1);
    }
}
