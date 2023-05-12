import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int sum;
        int size;
        int[] arr;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            size = Integer.parseInt(st.nextToken());

            sum = 0;
            arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            double avg = (double) sum / size;
            int cnt = 0;

            for (int j : arr) {
                if (avg < j) {
                    cnt++;
                }
            }

            double per = (double)cnt / size;

            DecimalFormat decimalFormat = new DecimalFormat("0.000");
            String formattedResult = decimalFormat.format(per * 100);


            sb.append(formattedResult).append("%").append("\n");

        }

        System.out.println(sb);  
    }

}