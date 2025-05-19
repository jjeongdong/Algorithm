import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(String.valueOf(charArray[i]));
        }

        System.out.println(answer);
    }
}
