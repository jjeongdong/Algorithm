import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st1;

        st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < M; i++) {
            st1 = new StringTokenizer(br.readLine(), " ");
            int startIndex = Integer.parseInt(st1.nextToken());
            int endIndex = Integer.parseInt(st1.nextToken());
            int num = Integer.parseInt(st1.nextToken());

            for (int j = startIndex; j <= endIndex; j++) {
                arr[j-1] = num;
            }
        }


        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}