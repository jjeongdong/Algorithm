import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int x = 0;
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            x = (int) str.charAt(i);

            if (x >= 65 && x <= 67) {
                sum += 3;
            } else if (x >= 68 && x <= 70) {
                sum += 4;
            } else if (x >= 71 && x <= 73) {
                sum += 5;
            } else if (x >= 74 && x <= 76) {
                sum += 6;
            } else if (x >= 77 && x <= 79) {
                sum += 7;
            } else if (x >= 80 && x <= 83) {
                sum += 8;
            } else if (x >= 84 && x <= 86) {
                sum += 9;
            } else if (x >= 87 && x <= 90) {
                sum += 10;
            }
        }


        System.out.println(sum);


    }
}