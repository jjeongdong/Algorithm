import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] arr = new int[9];
        int maxNum = 0;
        int maxIndex = 1;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (maxNum < arr[i]) {
                maxNum = arr[i];
                maxIndex = i + 1;
            }
        }

        System.out.println(maxNum);
        System.out.println(maxIndex);


    }
}