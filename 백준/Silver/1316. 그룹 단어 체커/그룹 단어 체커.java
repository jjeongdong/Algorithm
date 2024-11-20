import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int index = 0;
            boolean bool = false;
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char tmp = str.charAt(j);
                index = 0;
                for (int k = j + 1; k < str.length(); k++) {
                    if (tmp != str.charAt(k)) {
                        index = k;
                        break;
                    }
                }

                if (index == 0) {
                    break;
                }

                for (int k = index + 1; k < str.length(); k++) {
                    if (tmp == str.charAt(k)) {
                        bool = true;
                        break;
                    }
                }
            }


            if (!bool) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
