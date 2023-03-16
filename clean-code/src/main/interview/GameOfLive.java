package main.interview;


public class GameOfLive {

    private static int[][] map;

    public static void main(String[] args) {
        map = new int[][]{
                {0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1}
        };
        int[][] nextMap = multiply(map);

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 5; j++)
                System.out.print(nextMap[i][j]);
            System.out.println();
        }

    }

    private static int[][] multiply(final int[][] currentMap) {
        int[][] nextMap = new int[10][5];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                int liveCount = getLiveCount(i, j, currentMap);
                if (currentMap[i][j] == 1) {
                    if (liveCount < 2 || liveCount > 3) nextMap[i][j] = 0;
                    else nextMap[i][j] = 1;
                } else {
                    if (liveCount == 3) nextMap[i][j] = 1;
                    else nextMap[i][j] = 0;
                }
            }
        }
        return nextMap;
    }

    private static int getLiveCount(int x, int y, final int[][] currentMap) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i > 9 || j > 4 || (i == x && j == y)) {
                    continue;
                }
                if (currentMap[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

}
