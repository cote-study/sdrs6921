package week09.모음_사전;


import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> ALPHABET = new HashMap<>() {{
        put('A', 0);
        put('E', 1);
        put('I', 2);
        put('O', 3);
        put('U', 4);
    }};
    private static final int[] NUM_OF_DIGITS = {781, 156, 31, 6, 1};

    public int solution(String word) {
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            answer += NUM_OF_DIGITS[i] * ALPHABET.get(character) + 1;
        }
        return answer;
    }
}
