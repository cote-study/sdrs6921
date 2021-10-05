package week11.카카오프렌즈_컬러링북;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource(value = "testCase")
    void solution(final int m, final int n, final int[][] picture, final int[] expected) {
        Solution solution = new Solution();

        int[] actual = solution.solution(m, n, picture);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> testCase() {
        return Stream.of(
                arguments(6, 4, new int[][]{
                        {1, 1, 1, 0},
                        {1, 2, 2, 0},
                        {1, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 3},
                        {0, 0, 0, 3}
                }, new int[]{4, 5})
        );
    }
}
