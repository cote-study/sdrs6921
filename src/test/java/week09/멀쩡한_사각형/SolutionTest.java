package week09.멀쩡한_사각형;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void solution() {
        long answer = this.solution.solution(8, 12);

        assertThat(answer).isEqualTo(80);
    }
}
