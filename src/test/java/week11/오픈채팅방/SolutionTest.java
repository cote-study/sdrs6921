package week11.오픈채팅방;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("testCase")
    void solution(final String[] record, final String[] expected) {
        Solution solution = new Solution();
        String[] actual = solution.solution(record);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> testCase() {
        return Stream.of(
                arguments(new String[]{
                        "Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"
                }, new String[]{
                        "Prodo님이 들어왔습니다.",
                        "Ryan님이 들어왔습니다.",
                        "Prodo님이 나갔습니다.",
                        "Prodo님이 들어왔습니다."
                })
        );
    }
}
