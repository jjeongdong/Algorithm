import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                cnt++;
            }
        }


        boolean equals = String.valueOf(str.charAt(0)).equals(" ");
        boolean equals1 = String.valueOf(str.charAt(str.length() - 1)).equals(" ");

        if (equals && equals1) {
            System.out.println(cnt - 1);
        }
        else if (equals || equals1) {
            System.out.println(cnt);
        } else {
            System.out.println(cnt + 1);
        }
    }
}