

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(BigInteger.TWO.pow(N).subtract(BigInteger.ONE));

        if (N <= 20) {
            hanoi(N, '1', '2', '3');
            System.out.println(sb);
        }
    }

    private static void hanoi(int N, char from, char temp, char to) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(N - 1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(N - 1, temp, from, to);
    }
}
