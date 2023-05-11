import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int startIdx = 0, endIdx = 0;
        int[] arr = new int[N];
        int[] reverseArr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
            reverseArr[i] = arr[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            startIdx = Integer.parseInt(st.nextToken()) - 1;
            endIdx = Integer.parseInt(st.nextToken()) - 1;
            int Idx = endIdx;

            System.arraycopy(reverseArr, 0, arr, 0, N);

            for (int k = startIdx; k <= endIdx; k++) {
                reverseArr[k] = arr[Idx--];
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(reverseArr[i] + " ");
        }

    }
}