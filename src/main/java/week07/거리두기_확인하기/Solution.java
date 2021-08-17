package week07.거리두기_확인하기;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            if (isKeepDistance(places[i])) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private boolean isKeepDistance(final String[] place) {
        for (int y = 0; y < place.length; y++) {
            for (int x = 0; x < place[y].length(); x++) {
                if (place[y].charAt(x) == 'P' && !bfs(new Point(x, y), place)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(final Point point, final String[] place) {
        boolean[][] visited = new boolean[5][5];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.y][point.x] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5 || visited[nextY][nextX] || place[nextY].charAt(nextX) == 'X') {
                    continue;
                }

                Point next = new Point(nextX, nextY);

                if (manhattanDistance(point, next) <= 2) {
                    if (place[next.y].charAt(next.x) == 'P') {
                        return false;
                    }
                    queue.offer(next);
                    visited[next.y][next.x] = true;
                }
            }
        }

        return true;
    }

    private int manhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
