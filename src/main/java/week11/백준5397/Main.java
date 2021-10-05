package week11.백준5397;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final char CURSOR_LEFT = '<';
    private static final char CURSOR_RIGHT = '>';
    private static final char BACK_SPACE = '-';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String passwordValue = br.readLine();
            String password = parseFrom(passwordValue);
            bw.write(password);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String parseFrom(final String passwordValue) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> pre = new ArrayDeque<>();
        Deque<Character> post = new ArrayDeque<>();

        char[] passwordValues = passwordValue.toCharArray();

        for (char token : passwordValues) {
            if (token == CURSOR_LEFT) {
                if (!pre.isEmpty()) {
                    post.addFirst(pre.pop());
                }
                continue;
            }

            if (token == CURSOR_RIGHT) {
                if (!post.isEmpty()) {
                    pre.addFirst(post.pop());
                }
                continue;
            }

            if (token == BACK_SPACE) {
                if (!pre.isEmpty()) {
                    pre.pop();
                }
                continue;
            }

            pre.addFirst(token);
        }

        while (!post.isEmpty()) {
            pre.addFirst(post.pop());
        }

        int size = pre.size();

        for (int i = 0; i < size; i++) {
            sb.append(pre.removeLast());
        }

        return sb.toString();
    }
}
