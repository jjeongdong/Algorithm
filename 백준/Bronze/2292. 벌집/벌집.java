import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int answer = 1;
        int sum = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6 * i; j++) {
                sum++;
                if (sum == N) {
                    break;
                }
            }
            if (sum == N) break;
            answer++;
        }

        System.out.println(answer);
    }
}