package week07.이진_변환_반복하기;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String binaryString = s;

        while (binaryString.length() > 1) {
            String removed = binaryString.replace("0", "");
            answer[1] += binaryString.length() - removed.length();
            int removedLength = removed.length();
            binaryString = Integer.toBinaryString(removedLength);
            answer[0]++;
        }

        System.out.println(Integer.bitCount(6));

        return answer;
    }
}
