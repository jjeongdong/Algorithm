import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[30];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < 30; j++) {
                if (num == arr[j]) {
                    arr[j] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < 30; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }



    }
}