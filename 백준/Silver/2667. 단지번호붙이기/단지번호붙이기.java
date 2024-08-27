import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static int size;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visit[i][j]) {
                    size = 1;
                    T.DFS(i, j);
                    list.add(size);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void DFS(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (board[nx][ny] == 1 && !visit[nx][ny]) {
                    size++;
                    DFS(nx, ny);
                }
            }
        }
    }
}
