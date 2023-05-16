import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[x][y];
        int[][] arr2 = new int[x][y];
        int[][] arr3 = new int[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }
}