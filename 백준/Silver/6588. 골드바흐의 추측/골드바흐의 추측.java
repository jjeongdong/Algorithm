import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) {
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            boolean isProve = false;
            for (int i = 2; i <= N / 2; i++) {
                if (!isPrime[i] && !isPrime[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N - i));
                    isProve = true;
                    break;
                }
            }

            if (!isProve) {
                System.out.println("Goldbach's conjecture is wrong.");
            }

            N = Integer.parseInt(br.readLine());
        }
    }
}
