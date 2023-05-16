import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        String[][] array = new String[15][15];

        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            String[] splitArray = str.split("");

            System.arraycopy(splitArray, 0, array[i], 0, splitArray.length);
        }



        for (int i = 0; i < array.length; i++) {
            for (String[] strings : array) {
                if (strings[i] != null) {
                    sb.append(strings[i]);
                }
            }
        }

        System.out.println(sb);

    }
}