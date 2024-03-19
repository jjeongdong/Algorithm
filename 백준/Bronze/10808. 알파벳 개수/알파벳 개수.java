import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        char tmp = 'a';
        int[] arr = new int[26];
        int[] answer = new int[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = tmp++;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < arr.length; j++) {
                if (str.charAt(i) == arr[j]) {
                    answer[j]++;
                }
            }
        }

        for (int i:
             answer) {
            System.out.print(i + " ");
        }
    }
}
