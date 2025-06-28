

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.println(sb);
    }

    private static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                sb.append(number).append("\n");
                return;
            }
        }

        for (int i = 1; i < 10; i += 2) {
            if (isPrime(10 * number + i)) {
                DFS(10 * number + i, jarisu + 1);
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
