package week08.예산;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("test")
    void solution(int[] d, int budget, int expected) {
        Solution solution = new Solution();
        int answer = solution.solution(d, budget);
        assertThat(answer).isEqualTo(expected);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                arguments(new int[]{1, 3, 2, 5, 4}, 9, 3),
                arguments(new int[]{2, 2, 3, 3}, 10, 4)
        );
    }
}
