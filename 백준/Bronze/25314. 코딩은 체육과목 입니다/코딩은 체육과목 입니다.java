import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuffer str = new StringBuffer("int");

        for (int i = 0; i < (N/4); i++) {
            str.insert(0, "long ");
        }

        System.out.println(str);
    }
}