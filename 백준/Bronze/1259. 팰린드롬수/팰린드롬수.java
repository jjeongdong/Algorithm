import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                break;
            }

            String str = String.valueOf(num);
            StringBuilder sb = new StringBuilder(str);

            String reverse = sb.reverse().toString();

            if (str.equals(reverse)) {
                answer.append("yes").append("\n");
            } else {
                answer.append("no").append("\n");
            }
        }

        System.out.println(answer);
    }
}
