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
        int pointCount = 3;
        
        if (N == 1) System.out.println(9);
        else {
            for (int i = 0; i < N - 1; i++) {
                pointCount = pointCount + (pointCount - 1);
            }
            System.out.println(pointCount * pointCount);
        }

    }
}