import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
4 6
a t c i s w
 */

public class Main {

    static int N, M, cnt1, cnt2;
    static String[] arr;
    static String[] combo;
    static List<String> list;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        list = new ArrayList<>();       // 모음 list

        list.add("a");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("u");

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        combo = new String[N + 1];
        arr = new String[M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = st2.nextToken();
        }

        Arrays.sort(arr);

        T.DFS(0, 0);
        System.out.print(sb);
    }

    void DFS(int L, int S) {
        if (L == N) {
            if (cnt1 > 0 && cnt2 > 1) {             // 모음이 최소 한개 자음이 최소 두개일 때 sb에 append
                for (int i = 0; i < N; i++) {
                    sb.append(combo[i]);
                }

                sb.append("\n");
            }

        } else {
            for (int i = S; i < M; i++) {
                combo[L] = arr[i];
                if (list.contains(arr[i])) {        // 모음일 경우
                    cnt1++;
                    DFS(L + 1, i + 1);
                    cnt1--;
                } else {                            // 자음일 경우
                    cnt2++;
                    DFS(L + 1, i + 1);
                    cnt2--;
                }
            }
        }
    }
}
