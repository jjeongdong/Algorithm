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

        int Quarter = 25;
        int Dime = 10;
        int Nickel = 5;
        int Penny = 1;

        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());

            sb.append(money / Quarter).append(" ");
            sb.append(money % Quarter / Dime).append(" ");
            sb.append(money % Quarter % Dime / Nickel).append(" ");
            sb.append(money % Quarter % Dime % Nickel / Penny).append(" ").append("\n");
        }


        System.out.println(sb);
    }
}