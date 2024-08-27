import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = 0;
        boolean flag = false;
        Queue<Integer> Q = new LinkedList<>();

        int F = Integer.parseInt(st.nextToken());   // 전체
        int S = Integer.parseInt(st.nextToken());   // 시작
        int G = Integer.parseInt(st.nextToken());   // 목표
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] ch = new int[F + 1];

        Q.offer(S);
        ch[S] = 1;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {

                Integer cur = Q.poll();
                if (cur == G) {
                    System.out.println(L);
                    flag = true;
                    break;
                }

                int NU = cur + U;
                if (NU > 0 && NU <= F && ch[NU] == 0) {
                    ch[NU] = 1;
                    Q.offer(NU);
                }

                int ND = cur - D;
                if (ND > 0 && ND <= F && ch[ND] == 0) {
                    ch[ND] = 1;
                    Q.offer(ND);
                }
            }
            if (flag) {
                break;
            }

            L++;
        }

        if (!flag) {
            System.out.println("use the stairs");
        }
    }

}
