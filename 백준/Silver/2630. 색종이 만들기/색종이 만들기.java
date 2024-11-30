import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int N;
    public static int white = 0;
    public static int blue = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    public static void DFS(int row, int col, int size) {
        if (isFull(row, col, size)) {
            if (board[row][col] == 1) {
                blue++;
            }

            if (board[row][col] == 0) {
                white++;
            }

            return;
        }

        DFS(row, col, size / 2);
        DFS(row + size / 2, col, size / 2);
        DFS(row, col + size / 2, size / 2);
        DFS(row + size / 2, col + size / 2, size / 2);
    }

    public static boolean isFull(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
