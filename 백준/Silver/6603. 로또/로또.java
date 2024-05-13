import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[] arr;
    static int[] numArr;
    static int[] ch;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            numArr = new int[N];
            arr = new int[6];
            ch = new int[50];

            for (int i = 0; i < N; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            T.DFS(0, 0);
            System.out.println(sb);

        } while (N != 0);
    }

    void DFS(int L, int S) {
        if (L == 6) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = S; i < N; i++) {
                arr[L] = numArr[i];
                DFS(L + 1, i + 1);
            }
        }
    }
}
