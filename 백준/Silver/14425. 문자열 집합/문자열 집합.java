import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;


        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            hashMap.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (hashMap.containsKey(str)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
