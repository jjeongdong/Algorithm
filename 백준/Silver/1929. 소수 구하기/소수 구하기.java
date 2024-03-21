import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0 && i >= m) {
                sb.append(i).append("\n");
            }

            for (int j = i; j < arr.length; j+=i) {
                arr[j] = 1;
            }
        }

        System.out.println(sb);

    }
}
