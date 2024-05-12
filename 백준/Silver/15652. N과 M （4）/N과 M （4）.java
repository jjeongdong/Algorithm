import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N, M;
    static int[] arr;
    static int[] ch;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        arr = new int[M];
        ch = new int[30];

        T.DFS(0, 1);
        System.out.print(sb);
    }

    void DFS(int L, int S) {
        if (L == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = S; i <= N; i++) {
                arr[L] = i;
                DFS(L + 1, i);
            }
        }
    }
}
