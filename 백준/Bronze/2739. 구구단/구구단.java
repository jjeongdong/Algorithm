import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(br.readLine());
//        a = Integer.parseInt(st.nextToken());


        for (int i = 0; i < 9; i++) {
            System.out.println(a + " * " + (i + 1)  + " = " + (a * (i + 1)));
        }


        
    }
}