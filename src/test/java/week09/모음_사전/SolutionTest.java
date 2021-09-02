package week09.모음_사전;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {"AAAAE,6", "AAAE,10", "I,1563", "EIO,1189"})
    void solution(String word, int expected) {
        int answer = this.solution.solution(word);

        assertThat(answer).isEqualTo(expected);
    }
}
