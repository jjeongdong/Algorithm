import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < N; j++) {
                if (i + j >= N) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}