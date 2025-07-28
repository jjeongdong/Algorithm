import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] op;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) {
        if (N == idx) {
            if (num > MAX) MAX = num;
            if (num < MIN) MIN = num;
        }

        if (op[0] >= 1) {
            op[0]--;
            dfs(num + arr[idx], idx + 1);
            op[0]++;
        }

        if (op[1] >= 1) {
            op[1]--;
            dfs(num - arr[idx], idx + 1);
            op[1]++;
        }

        if (op[2] >= 1) {
            op[2]--;
            dfs(num * arr[idx], idx + 1);
            op[2]++;
        }

        if (op[3] >= 1) {
            op[3]--;
            dfs(num / arr[idx], idx + 1);
            op[3]++;
        }

    }
}
