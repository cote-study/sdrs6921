package week08.직업군_추천하기;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    private static Map<String, Map<String, Integer>> tables = new HashMap<>();
    private static Map<String, Integer> preferenceLanguages = new HashMap<>();

    public String solution(String[] table, String[] languages, int[] preference) {
        parse(table);
        parse(languages, preference);
        return recommendCompany();
    }

    private void parse(final String[] table) {
        for (final String infos : table) {
            String[] info = infos.split(" ");
            Map<String, Integer> tableInfo = new HashMap<>();
            int score = 5;
            for (int j = 1; j <= 5; j++) {
                tableInfo.put(info[j], score--);
            }
            tables.put(info[0], tableInfo);
        }
    }

    private void parse(final String[] languages, final int[] preference) {
        IntStream.range(0, languages.length)
                .forEach(index ->
                        preferenceLanguages.put(languages[index], preference[index]));
    }

    private String recommendCompany() {
        String recommendedCompany = "";
        int maxScore = 0;

        for (String company : tables.keySet()) {
            Map<String, Integer> companyNeededLanguage = tables.get(company);
            int totalScore = 0;
            for (String language : preferenceLanguages.keySet()) {
                if (companyNeededLanguage.containsKey(language)) {
                    totalScore += companyNeededLanguage.get(language) *
                            preferenceLanguages.get(language);
                }
            }
            if (maxScore < totalScore) {
                maxScore = totalScore;
                recommendedCompany = company;
            } else if (maxScore == totalScore) {
                if (recommendedCompany.compareTo(company) > 0) {
                    recommendedCompany = company;
                }
            }
        }

        return recommendedCompany;
    }
}
