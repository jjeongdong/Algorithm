import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, String> hashMap2 = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            hashMap1.put(str, i + 1);
            hashMap2.put(i + 1, str);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (Character.isDigit(str.charAt(0))) {
                sb.append(hashMap2.get(Integer.parseInt(str))).append("\n");
            } else if (Character.isAlphabetic(str.charAt(0))) {
                sb.append(hashMap1.get(str)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
