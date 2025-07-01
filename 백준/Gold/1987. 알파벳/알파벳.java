import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int R;
    static int C;
    static boolean[][] visited;
    static char[][] board;
    static boolean[] alpha;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = Integer.MIN_VALUE;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];
        board = new char[R][C];
        alpha = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        alpha[board[0][0] - 'A'] = true;
        visited[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[nx][ny] && !alpha[board[nx][ny] - 'A']) {
                    visited[nx][ny] = true;
                    alpha[board[nx][ny] - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    visited[nx][ny] = false;
                    alpha[board[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}
