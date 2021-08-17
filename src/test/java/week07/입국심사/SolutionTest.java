package week07.입국심사;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void solution() {
        int n = 6;
        int[] times = {7, 10};

        long answer = this.solution.solution(n, times);

        assertThat(answer).isEqualTo(28);
    }
}
