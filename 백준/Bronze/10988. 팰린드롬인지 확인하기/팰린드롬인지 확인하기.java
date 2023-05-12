import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        char[] reverse = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            reverse[i] = str.charAt(reverse.length - 1- i);
        }

        for (char c : reverse) {
            sb.append(c);
        }

        if (sb.toString().equals(str)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}