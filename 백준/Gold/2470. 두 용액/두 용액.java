import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int gap = Integer.MAX_VALUE;
        int MAX = 0;
        int MIN = 0;
        int lt = 0;
        int rt = arr.length - 1;

        Arrays.sort(arr);

        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            int tmp = Math.abs(sum);

            if (tmp < gap) {
                gap = tmp;
                MAX = arr[rt];
                MIN = arr[lt];
            }


            if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        sb.append(MIN).append(" ").append(MAX);
        System.out.println(sb);
    }
}
