import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        Queue<Point> Fire = new LinkedList<>();
        Queue<Point> Jihoon = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean flag = false;

        int R = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st1.nextToken());

        String[][] board1 = new String[R][C];
        String[][] board2 = new String[R][C];

        int[][] fire_visit = new int[R][C];
        int[][] fire_ava = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                board1[i][j] = str.substring(j, j + 1);
                board2[i][j] = str.substring(j, j + 1);

                if (board1[i][j].equals("J")) {
                    Jihoon.offer(new Point(i, j));

                }
                if (board1[i][j].equals("F")) {
                    Fire.offer(new Point(i, j));
                    fire_ava[i][j] = 1;
                }
            }
        }

        int L = 1;

        // 불의 BFS
        while (!Fire.isEmpty()) {
            int len = Fire.size();

            for (int i = 0; i < len; i++) {
                Point tmp = Fire.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && (board1[nx][ny].equals(".") || board1[nx][ny].equals("J"))) {
                        Fire.offer(new Point(nx, ny));
                        fire_visit[nx][ny] = L;
                        fire_ava[nx][ny] = 1;
                        board1[nx][ny] = "F";
                    }
                }
            }

            L++;
        }

        L = 1;

        // 지훈의 DFS
        while (!Jihoon.isEmpty()) {
            if (flag) break;

            int len = Jihoon.size();

            for (int i = 0; i < len; i++) {
                if (flag) break;
                Point tmp = Jihoon.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    // 범위 밖을 빠져나갈 경우 - 탈출
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(L);
                        flag = true;
                        break;
                    }

                    // 불이 번질 가능성이 있으면 지훈의 방문수가 더 적어야하고 불이 번질 가능성 (불이 막혀있을 경우) 이 없으면 참
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && board2[nx][ny].equals(".")
                            && ((fire_visit[nx][ny] > L && fire_ava[nx][ny] == 1) || fire_ava[nx][ny] == 0)) {

                        Jihoon.offer(new Point(nx, ny));
                        board2[nx][ny] = "J";
                    }
                }
            }

            L++;
        }

        if (!flag) {
            System.out.println("IMPOSSIBLE");
        }
    }
}
