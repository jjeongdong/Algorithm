import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            char str1 = str.charAt(0);
            char str2 = str.charAt(str.length() - 1);

            sb.append(str1).append(str2);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}