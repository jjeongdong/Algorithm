import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        if (m >= 45) {
            m -= 45;
        } else {
            if (h == 0) {
                h = 23;
            } else {
                h -= 1;
            }
            m += 15;
        }

        System.out.println(h + " " + m);
    }
}