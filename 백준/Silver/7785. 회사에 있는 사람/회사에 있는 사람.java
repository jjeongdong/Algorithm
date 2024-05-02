import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if (command.equals("enter")) {
                hashMap.put(name, 1);
            } else {
                hashMap.put(name, hashMap.get(name) -1);
            }
        }

        ArrayList<String> list = new ArrayList<String>(hashMap.keySet());
        list.sort(Collections.reverseOrder());

        for (String key : list) {
            if (hashMap.get(key) == 1) {
                System.out.println(key);
            }
        }
    }
}
