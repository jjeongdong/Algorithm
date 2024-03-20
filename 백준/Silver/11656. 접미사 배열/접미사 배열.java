import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        char[] arr = br.readLine().toCharArray();
        String[] answer = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < arr.length; j++) {
                sb.append(arr[j]);
            }

            answer[i] = sb.toString();
        }

        Arrays.sort(answer);

        for (String tmp : answer) {
            System.out.println(tmp);
        }

    }
}
