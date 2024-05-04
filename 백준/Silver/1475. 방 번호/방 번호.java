import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int max = Integer.MIN_VALUE;

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            String substring = str.substring(i, i + 1);
            arr[Integer.parseInt(substring)]++;
        }

        arr[6] = (arr[6] + arr[9] + 1) / 2;

        for (int i = 0; i < 9; i++) {
            if(max < arr[i]) max = arr[i];
        }
        System.out.println(max);

    }
}
