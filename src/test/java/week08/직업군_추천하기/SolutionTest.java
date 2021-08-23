package week08.직업군_추천하기;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("test")
    void solution(String[] table, String[] languages, int[] preference, String expected) {
        Solution solution = new Solution();
        String answer = solution.solution(table, languages, preference);
        assertThat(answer).isEqualTo(expected);
    }

    static Stream<Arguments> test() {
        return Stream.of(
                arguments(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#",
                                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                                "GAME C++ C# JAVASCRIPT C JAVA"},
                        new String[]{"PYTHON", "C++", "SQL"},
                        new int[]{7, 5, 5}, "HARDWARE")
//                arguments(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#",
//                                "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
//                                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
//                                "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
//                                "GAME C++ C# JAVASCRIPT C JAVA"},
//                        new String[]{"JAVA", "JAVASCRIPT"},
//                        new int[]{7, 5},
//                        "PORTAL")
        );
    }
}
