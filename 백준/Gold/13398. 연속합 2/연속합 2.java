import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = arr[0];
        int answer = arr[0];

        for (int i = 1; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);

            answer = Math.max(answer, dp1[i]);
        }

        int[] dp2 = new int[N];
        dp2[N - 1] = arr[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
        }

        // 특정 값을 지웠다고 가정하고, 그 값의 오른쪽 방향과 왼쪽 방향의 최대 연속 합을 더함.
        for (int i = 1; i < N - 1; i++) {
            int temp = dp1[i - 1] + dp2[i + 1];

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
