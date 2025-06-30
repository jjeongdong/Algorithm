import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] visited;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        visited = new boolean[N][M];
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                if (board[i][j] == '-') dfs(i, j, true);
                else if (board[i][j] == '|') dfs(i, j, false);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true;
        if (row) {
            j++;
            if (j < M && board[i][j] == '-') dfs(i, j, true);
        } else {
            i++;
            if (i < N && board[i][j] != '-') dfs(i, j, false);
        }

    }
}
