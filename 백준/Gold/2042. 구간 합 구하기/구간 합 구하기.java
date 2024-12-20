import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        for (int i = 1; i <= 100; i++) {
            if ((int) Math.pow(2, i) >= N) {
                treeHeight = i;
                break;
            }
        }

        tree = new long[(int) Math.pow(2, treeHeight) * 2];
        int startIdx = (int) Math.pow(2, treeHeight);

        for (int i = 0; i < N; i++) {
            tree[startIdx++] = Long.parseLong(br.readLine());
        }

        for (int i = tree.length - 1; i > 1; i--) {
            tree[i / 2] += tree[i];
        }

        startIdx = (int) Math.pow(2, treeHeight);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());


            if (a == 1) {   // 데이터 변경
                int s = Integer.parseInt(st.nextToken());
                long e = Long.parseLong(st.nextToken());
                changeVal(startIdx - 1 + s,  e);
            } else if (a == 2) { // 구간합 구하기
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                s = s + startIdx - 1;
                e = e + startIdx - 1;
                long sum = getSum(s, e);
                sb.append(sum).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static long getSum(int s, int e) {
        long partSum = 0;

        while (s <= e) {
            if (s % 2 == 1) partSum += tree[s++];
            if (e % 2 == 0) partSum += tree[e--];
            s /= 2;
            e /= 2;
        }

        return partSum;
    }

    private static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }
}
