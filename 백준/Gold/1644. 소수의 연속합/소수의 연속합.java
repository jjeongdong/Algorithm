import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        ArrayList<Integer> decimal = new ArrayList<>();
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) {
                for (int j = i + i; j < N + 1; j += i) {
                    arr[j] = 1;
                }
            }
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                decimal.add(i);
            }
        }

        int sum = 0;
        int start = 0;
        for (int end = 0; end < decimal.size(); end++) {
            sum += decimal.get(end);

            while (sum >= N) {
                if (sum == N) cnt++;
                sum -= decimal.get(start++);
            }
        }

        System.out.println(cnt);
    }
}
