import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        String num1 = st.nextToken();
        String num2 = st.nextToken();

        String max = "";

        for (int i = 2; i >= 0; i--) {
            int i1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int i2 = Integer.parseInt(String.valueOf(num2.charAt(i)));

            if (i1 == i2) {
                continue;
            }
            else if (i1 < i2) {
                max = num2;
                break;
            } else {
                max = num1;
                break;
            }
        }

        StringBuilder reverse = new StringBuilder();

        for (int i = 2; i >= 0 ; i--) {
            reverse.append(String.valueOf(max.charAt(i)));
        }

        System.out.println(reverse);
    }
}