package week07.점프와_순간_이동;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {"5,2", "6,2", "5000,5"})
    void solution(int n, int expected) {
        int answer = this.solution.solution(n);

        assertThat(answer).isEqualTo(expected);
    }
}
