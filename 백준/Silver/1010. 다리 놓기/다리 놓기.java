import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long answer = 1;

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N > M / 2) {
                N = M - N;
            }

            if (N == M) {
                System.out.println(1);
                break;
            }

            long tmp = 1;

            for (int j = 0; j < N; j++) {
                answer *= M--;
            }

            for (int j = 0; j < N; j++) {
                answer /= tmp++;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
