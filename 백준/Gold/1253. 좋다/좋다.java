import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            int target = arr[i];

            while (end > start) {
                if (start == i || end == i) {
                    if (start == i) start++;
                    else end--;
                } else {
                    int sum = arr[start] + arr[end];
                    if (sum < target) start++;
                    else if (sum > target) end--;
                    else {
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
