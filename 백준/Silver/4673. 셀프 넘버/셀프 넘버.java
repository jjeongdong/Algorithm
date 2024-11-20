import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[10001];

        for (int i = 1; i < 10001; i++) {
            String str = String.valueOf(i);
            int num = Integer.parseInt(str);

            for (int j = 0; j < str.length(); j++) {
                int tmp = Integer.parseInt(String.valueOf(str.charAt(j)));
                num += tmp;
            }

            if (num <= 10000) {
                arr[num] = true;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
