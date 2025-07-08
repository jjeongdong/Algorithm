

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];
        int[] weightArr = new int[N];
        int[] valueArr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            weightArr[i] = weight;
            valueArr[i] = value;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= weightArr[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weightArr[i]] + valueArr[i]);
                answer = Math.max(dp[j], answer);
            }
        }

        System.out.println(answer);
    }
}
