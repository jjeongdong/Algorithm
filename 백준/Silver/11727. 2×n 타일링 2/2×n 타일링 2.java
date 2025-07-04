

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) %  10007;
        }

        System.out.println(dp[N-1]);
    }
}
