import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int answer = Integer.MIN_VALUE;
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        T.DFS(0, 0);
        System.out.println(answer);
    }

    private void DFS(int L, int S) {
        if (L >= N) {
            answer = Math.max(S, answer);
            return;
        }

        if (L + arr[L][0] <= N) {
            DFS(L + arr[L][0], S + arr[L][1]);
        } else {
            DFS(L + arr[L][0], S);
        }

        DFS(L + 1, S);
    }
}
