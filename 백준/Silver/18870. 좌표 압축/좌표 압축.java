import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sortedArr[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortedArr);
        int rank = 0;

        for (int i = 0; i < N; i++) {
            if (!hashMap.containsKey(sortedArr[i])) {
                hashMap.put(sortedArr[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(hashMap.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
