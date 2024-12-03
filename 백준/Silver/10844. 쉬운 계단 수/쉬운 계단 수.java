import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long MOD = 1000000000L; // 모듈러 값

        // dp[i][j]: 길이가 i이고 마지막 자리가 j인 계단 수의 개수
        long[][] dp = new long[N + 1][10];

        // 길이가 1인 계단 수 초기화
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // DP 테이블 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1]; // 이전 자리가 j-1인 경우
                if (j < 9) dp[i][j] += dp[i - 1][j + 1]; // 이전 자리가 j+1인 경우
                dp[i][j] %= MOD; // 모듈러 연산
            }
        }

        // 길이가 N인 계단 수의 총합 계산
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[N][i];
            result %= MOD; // 모듈러 연산
        }

        System.out.println(result);
    }
}
