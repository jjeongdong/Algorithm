import java.io.*;
import java.util.*;

/***
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MIN_VALUE;

        int[][] arr = new int[N][N];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(arr[0][0]);
            System.exit(0);
        }

        arr[1][0] += arr[0][0];
        arr[1][1] += arr[0][0];

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] += arr[i - 1][j];
                } else if (j == i) {
                    arr[i][j] += arr[i - 1][j - 1];
                } else if (j > 0) {
                    arr[i][j] += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
                }

            }
        }


        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, arr[N - 1][i]);
        }

        System.out.println(answer);
    }
}
