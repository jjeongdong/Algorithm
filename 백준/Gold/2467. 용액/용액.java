import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = N - 1;
        long a = 0;
        long b = 0;
        long min = Integer.MAX_VALUE;

        while (lt < rt) {
            long tmp = arr[lt] + arr[rt];
            if (Math.abs(tmp) < min) {
                min = Math.abs(tmp);
                a = arr[lt];
                b = arr[rt];
            }

            if (tmp > 0) rt--;
            else if (tmp < 0) {
                lt++;
            } else {
                break;
            }
        }

        System.out.println(a + " " + b);
    }
}
