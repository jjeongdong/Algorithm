import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hashMap = new HashMap<>();

        int sum = 1;

        for (int i = 0; i <= 9; i++) {
            hashMap.put(String.valueOf(i), 0);
        }

        for (int i = 0; i < 3; i++) {
            sum *= Integer.parseInt(br.readLine());
        }

        for (char tmp : String.valueOf(sum).toCharArray()) {
            hashMap.put(String.valueOf(tmp), hashMap.get(String.valueOf(tmp)) + 1);
        }

        for (int i = 0; i < hashMap.size(); i++) {
            System.out.println(hashMap.get(String.valueOf(i)));
        }


    }
}
