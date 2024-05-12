import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N, M;
    static int[] arr;
    static int[] ch;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        arr = new int[M];
        ch = new int[30];

        T.DFS(0, 1);
    }

    void DFS(int L, int S) {
        if (L == M) {
            for (int tmp : arr) {
                System.out.print(tmp + " ");
            }
            System.out.println();
        } else {
            for (int i = S; i <= N; i++) {
                if (ch[i] == 0) {
                    arr[L] = i;
                    ch[i] = 1;
                    DFS(L + 1, i + 1);
                    ch[i] = 0;
                }
            }

        }
    }
}
