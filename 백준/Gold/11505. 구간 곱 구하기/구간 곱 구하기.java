import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000007;
    static int treeStartIndex;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());   // 변경이 일어나는 횟수
        int C = Integer.parseInt(st.nextToken());   // 구간 곱을 구하는 횟수
        int K = 1;

        // 1. 트리 초기화
        // 2^k가 N보다 크거나 같은 k의 최솟값을 구함
        while (Math.pow(2, K) < N) {
            K++;
        }

        // 2 * 2^k를 트리의 크기로 잡음
        int treeSize = (int) Math.pow(2, K + 1);
        tree = new long[treeSize];

        // 시작 인덱스를 2^k로 잡음, 리프노드 초기화
        treeStartIndex = (int) Math.pow(2, K);
        for (int i = treeStartIndex; i < treeStartIndex + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        // 나머지 리프 노드는 1로 채우기
        for (int i = treeStartIndex + N; i < treeSize; i++) {
            tree[i] = 1;
        }

        // 부모 노드 초기화
        for (int i = treeStartIndex - 1; i > 0; i--) {
            tree[i] = ((tree[i * 2] * tree[i * 2 + 1]) % MOD);
        }

        // 질의값 구하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + C; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (op == 1) changeData(x, y);
            else sb.append(calculateMul(x, y)).append("\n");
        }

        System.out.println(sb);
    }

    public static long calculateMul(int start_index, int end_index) {
        long answer = 1;
        start_index = treeStartIndex + start_index - 1;
        end_index = treeStartIndex + end_index - 1;

        while (start_index <= end_index) {
            if (start_index % 2 == 1) answer = (answer * tree[start_index]) % MOD;

            if (end_index % 2 == 0) answer = (answer * tree[end_index]) % MOD;

            start_index = (start_index + 1) / 2;
            end_index = (end_index - 1) / 2;
        }

        return answer;
    }

    public static void changeData(int index, int data) {
        index = treeStartIndex + index - 1;
        tree[index] = data;  // 리프 노드 값을 갱신

        // 위로 올라가며 부모 노드 갱신
        while (index > 1) {
            index /= 2;
            tree[index] = ((tree[index * 2] * tree[index * 2 + 1]) % MOD);
        }
    }
}
