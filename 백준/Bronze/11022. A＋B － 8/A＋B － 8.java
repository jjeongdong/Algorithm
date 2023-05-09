import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        int num1, num2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i+1).append(": ").append(num1).append(" + ").append(num2).append(" = ");
            sb.append(num1 + num2);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}