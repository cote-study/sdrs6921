package week07.이진_변환_반복하기;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {"110010101001,3,8", "01110,3,3", "1111111,4,1"})
    void solution(String s, int changeCount, int removedZero) {
        Solution solution = new Solution();

        int[] answer = solution.solution(s);

        assertThat(answer).containsExactly(changeCount, removedZero);
    }
}
