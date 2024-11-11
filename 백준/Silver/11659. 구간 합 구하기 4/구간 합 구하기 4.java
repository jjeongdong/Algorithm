import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strArr = br.readLine().split(" ");
        int[] sum = new int[N + 1];
        sum[0] = 0;

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(strArr[i - 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(sum[b] - sum[a - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
