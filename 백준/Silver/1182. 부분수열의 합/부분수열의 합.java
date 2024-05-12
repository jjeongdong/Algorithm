import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N, S;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        S = Integer.parseInt(st1.nextToken());

        arr = new int[30];
        answer = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        T.DFS(0, 0);
        if (S == 0) answer--;

        System.out.println(answer);
    }

    void DFS(int L, int sum) {
        if (L == N) {
            if (sum == S)
                answer++;
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }
}
