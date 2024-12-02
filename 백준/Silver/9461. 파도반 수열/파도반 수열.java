import java.io.*;
import java.util.*;

/***
 * 5
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = arr[2] = arr[3] = 1;
        arr[4] = 2;

        for (int i = 5; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb);
    }
}
