import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;

        while (rt > lt) {
            int sum = arr[lt] + arr[rt];
            if (sum == M) {
                lt++;
                count++;
            } else if (sum < M) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(count);
    }
}
