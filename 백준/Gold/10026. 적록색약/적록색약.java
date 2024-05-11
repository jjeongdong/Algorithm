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

    static Queue<Point> Q1;
    static Queue<Point> Q2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] ch1;
    static int[][] ch2;
    static String[][] board1;
    static String[][] board2;
    static int answer1;
    static int answer2;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board1 = new String[N][N];
        board2 = new String[N][N];
        ch1 = new int[N][N];
        ch2 = new int[N][N];
        answer1 = 0;
        answer2 = 0;
        Q1 = new LinkedList<>();
        Q2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board1[i][j] = String.valueOf(str.charAt(j));
                if (str.charAt(j) == 'G') {
                    board2[i][j] = "R";
                } else {
                    board2[i][j] = String.valueOf(str.charAt(j));
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ch1[i][j] == 0) {
                    answer1++;
                    Q1.offer(new Point(i, j));
                    ch1[i][j] = 1;
                    T.BFS1(ch1, board1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ch2[i][j] == 0) {
                    answer2++;
                    Q2.offer(new Point(i, j));
                    ch2[i][j] = 1;
                    T.BFS2(ch2, board2);
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    public void BFS1(int[][] ch, String[][] board) {
        while (!Q1.isEmpty()) {
            int len = Q1.size();
            for (int i = 0; i < len; i++) {
                Point tmp = Q1.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && board[nx][ny].equals(board[tmp.x][tmp.y])) {
                        ch[nx][ny] = 1;
                        Q1.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public void BFS2(int[][] ch, String[][] board) {
        while (!Q2.isEmpty()) {
            int len = Q2.size();
            for (int i = 0; i < len; i++) {
                Point tmp = Q2.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && board[nx][ny].equals(board[tmp.x][tmp.y])) {
                        ch[nx][ny] = 1;
                        Q2.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
