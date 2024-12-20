import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static char[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N + 1][2];

        alpha = new char[27];
        for (int i = 1; i <= 26; i++) {
            alpha[i] = (char) ('A' + i - 1);
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);
            int index = root - 'A' + 1; // root를 배열 인덱스로 변환
            arr[index][0] = lt;
            arr[index][1] = rt;
        }

        preDFS(1);
        System.out.println();
        midDFS(1);
        System.out.println();
        postDFS(1);
    }

    private static void preDFS(int num) {
        if (1 <= num && num <= 26) {
            System.out.print(alpha[num]);
            preDFS(arr[num][0] - 64);
            preDFS(arr[num][1] - 64);
        } else {
            return;
        }
    }

    private static void midDFS(int num) {
        if (1 <= num && num <= 26) {
            midDFS(arr[num][0] - 64);
            System.out.print(alpha[num]);
            midDFS(arr[num][1] - 64);
        } else {
            return;
        }
    }

    private static void postDFS(int num) {
        if (1 <= num && num <= 26) {
            postDFS(arr[num][0] - 64);
            postDFS(arr[num][1] - 64);
            System.out.print(alpha[num]);
        } else {
            return;
        }
    }
}
