import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left == '.') {
                tree[root - 'A'][0] = -1;
            } else {
                tree[root - 'A'][0] = left - 'A';
            }

            if (right == '.') {
                tree[root - 'A'][1] = -1;
            } else {
                tree[root - 'A'][1] = right - 'A';
            }
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb);
    }

    private static void preOrder(int num) {
        if (num == -1) return;
        sb.append(Character.toChars(num + 'A'));
        preOrder(tree[num][0]);
        preOrder(tree[num][1]);
    }

    private static void inOrder(int num) {
        if (num == -1) return;
        inOrder(tree[num][0]);
        sb.append(Character.toChars(num + 'A'));
        inOrder(tree[num][1]);
    }

    private static void postOrder(int num) {
        if (num == -1) return;
        postOrder(tree[num][0]);
        postOrder(tree[num][1]);
        sb.append(Character.toChars(num + 'A'));
    }
}
