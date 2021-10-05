package week11.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {

    private static final String DELIMITER = " ";

    private static final int OPTION = 0;
    private static final int USER_UID = 1;
    private static final int USER_NAME = 2;
    private static final int MESSAGE_USER_ID = 0;
    private static final int MESSAGE_CONTENT = 1;

    private static final String ENTER = "Enter";
    private static final String CHANGE = "Change";
    private static final String LEAVE = "Leave";
    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    private static final String LEAVE_MESSAGE = "님이 나갔습니다.";

    private final Map<String, String> userInfo = new HashMap<>();
    private final Queue<String[]> messages = new LinkedList<>();

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();

        for (String commands : record) {
            parse(commands);
        }

        for (String[] message : messages) {
            String ans = userInfo.get(message[MESSAGE_USER_ID]) + message[MESSAGE_CONTENT];
            answer.add(ans);
        }

        return answer.toArray(String[]::new);
    }

    private void parse(final String commands) {
        String[] command = commands.split(DELIMITER);
        String commandOption = command[OPTION];
        String userUid = command[USER_UID];

        if (commandOption.equals(ENTER)) {
            String userName = command[USER_NAME];
            userInfo.put(userUid, userName);
            String[] message = new String[]{userUid, ENTER_MESSAGE};
            messages.offer(message);
        }

        if (commandOption.equals(CHANGE)) {
            String userName = command[USER_NAME];
            userInfo.put(userUid, userName);
        }

        if (commandOption.equals(LEAVE)) {
            String[] message = {userUid, LEAVE_MESSAGE};
            messages.offer(message);
        }
    }
}
