import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N, answer;
    static int[] arr;
    static int[] ch1;
    static int[] ch2;
    static int[] ch3;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;

        arr = new int[10];
        ch1 = new int[40];
        ch2 = new int[40];
        ch3 = new int[40];
        T.DFS(0);

        System.out.println(answer);

    }

    void DFS(int L) {
        if (L == N) {
            answer++;
        } else {
            for (int i = 0; i < N; i++) {
                if (ch1[i] == 1 || ch2[i + L] == 1 || ch3[L - i + N - 1] == 1) {
                    continue;
                }

                ch1[i] = 1;
                ch2[i + L] = 1;
                ch3[L - i + N - 1] = 1;
                DFS(L + 1);
                ch1[i] = 0;
                ch2[i + L] = 0;
                ch3[L - i + N - 1] = 0;
            }

        }
    }
}
