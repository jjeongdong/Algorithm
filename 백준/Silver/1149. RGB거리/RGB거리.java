import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]) ;
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]) ;
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]) ;

        }

        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, arr[N - 1][i]);
        }

        System.out.println(answer);
    }
}
