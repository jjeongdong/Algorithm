import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int[] arr = {1, 1, 2, 2, 2, 8};


        for (int i : arr) {
            sb.append(i - Integer.parseInt(st.nextToken())).append(" ");
        }

        System.out.println(sb);
    }
}