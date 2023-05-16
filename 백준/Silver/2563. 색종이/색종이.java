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

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[100][100];
        int totalArea = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x - 1; j < x + 9; j++) {
                for (int k = y - 1; k < y + 9; k++) {
                    array[j][k] = 1;
                }
            }


        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                totalArea += array[i][j];
            }
        }

        System.out.println(totalArea);
    }
}