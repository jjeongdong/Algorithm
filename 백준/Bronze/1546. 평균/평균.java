import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        
        double[] arr = new double[N];
        double sum = 0;
        
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            sum += arr[i];
        }

        double max = arr[0];

        for (int i = 0; i < N; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        
        System.out.println(sum / max * 100 / N );
    }
}