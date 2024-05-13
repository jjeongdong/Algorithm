import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static int N, M;
    static int[] arr;
    static int[] numArr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        numArr = new int[N];
        arr = new int[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(numArr);

        T.DFS(0);
        System.out.print(sb);
    }

    void DFS(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                arr[L] = numArr[i];
                DFS(L + 1);
            }
        }
    }
}
