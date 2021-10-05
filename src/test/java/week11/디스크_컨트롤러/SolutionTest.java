package week11.디스크_컨트롤러;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("test")
    void solution(final int[][] jobs, final int expected) {
        Solution solution = new Solution();
        int actual = solution.solution(jobs);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.arguments(new int[][]{{0, 3}, {1, 9}, {2, 6}}, 9)
        );
    }
}
