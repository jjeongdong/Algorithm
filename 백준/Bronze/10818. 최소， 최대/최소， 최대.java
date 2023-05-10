import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");


        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxNum = arr[0];
        int minNum = arr[0];

        for (int i = 0; i < N; i++) {
            maxNum = Math.max(maxNum, arr[i]);
            minNum = Math.min(minNum, arr[i]);
        }

        System.out.println(minNum);
        System.out.println(maxNum);
        
    }
}