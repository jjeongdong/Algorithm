import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String N = br.readLine();

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        System.out.println(sum);


    }
}