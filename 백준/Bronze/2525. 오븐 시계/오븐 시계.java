import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int addTime = Integer.parseInt(br.readLine());
        br.close();

        if (m + addTime >= 60) {
            h += (m + addTime) / 60;
            m = (m + addTime) % 60;
        } else {
            m += addTime;
        }



        System.out.println((h%24) + " " + m);
    }
}