package week11.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Pixel {
    private final int row;
    private final int column;
    private final int value;

    public Pixel(final int row, final int column, final int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }
}

public class Solution {

    private static final int[] D_ROW = {1, 0, -1, 0};
    private static final int[] D_COLUMN = {0, 1, 0, -1};

    private int numberOfArea = 0;
    private int maxSizeOfOneArea = 0;
    private int m;
    private int n;

    private boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        this.m = m;
        this.n = n;

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {

                if (!visited[row][column] && picture[row][column] != 0) {
                    visited[row][column] = true;
                    Pixel pixel = new Pixel(row, column, picture[row][column]);
                    int sizeOfOneArea = bfs(picture, pixel);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(final int[][] picture, Pixel pixel) {
        int count = 1;

        Queue<Pixel> pixels = new LinkedList<>();
        pixels.offer(pixel);

        while (!pixels.isEmpty()) {
            Pixel currentPixel = pixels.poll();

            for (int i = 0; i < D_ROW.length; i++) {
                int nextRow = currentPixel.getRow() + D_ROW[i];
                int nextColumn = currentPixel.getColumn() + D_COLUMN[i];

                if (nextRow < 0 || nextRow >= m || nextColumn < 0 || nextColumn >= n
                        || currentPixel.getValue() != picture[nextRow][nextColumn] || visited[nextRow][nextColumn]) {
                    continue;
                }

                visited[nextRow][nextColumn] = true;
                Pixel nextPixel = new Pixel(nextRow, nextColumn, picture[nextRow][nextColumn]);
                pixels.offer(nextPixel);
                count++;
            }
        }
        return count;
    }
}
