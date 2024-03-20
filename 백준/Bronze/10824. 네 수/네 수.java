import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken() + st.nextToken();
            String str2 = st.nextToken() + st.nextToken();

            long a = Long.parseLong(str1);
            long b = Long.parseLong(str2);

            System.out.println(a + b);
        } catch (NumberFormatException e) {
            System.out.println("a");
        }

    }
}
