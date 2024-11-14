import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while (st.hasMoreTokens()) {
            int tmp = 0;
            StringTokenizer addition = new StringTokenizer(st.nextToken(), "+");

            while (addition.hasMoreTokens()) {
                tmp += Integer.parseInt(addition.nextToken());
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }

        System.out.println(sum);
    }
}
