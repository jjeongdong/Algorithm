import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, arr[i]);
        }
        
        for (int i = 1; i <= maxValue; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] >= i) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt * i);
        }

        System.out.println(answer);
    }
}
