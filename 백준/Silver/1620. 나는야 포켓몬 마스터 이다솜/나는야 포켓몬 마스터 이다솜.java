import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] arr = new String[N + 1];
        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            arr[i + 1] = str;
            hashMap.put(str, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                System.out.println(arr[Integer.parseInt(str)]);
            } else if (Character.isAlphabetic(str.charAt(0))) {
                System.out.println(hashMap.get(str));
            }
        }
    }
}
