import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long N = 1;

        while (sum <= S) {
            sum += N;
            N++;
        }

        System.out.println(N - 2);
    }
}
