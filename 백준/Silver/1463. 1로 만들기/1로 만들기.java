import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int L = 0;
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[x + 1];
        ch[x] = 1;
        Q.offer(x);

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i = 0; i < len; i++) {
                int v = Q.poll();

                if (v == 1) {
                    System.out.println(L);
                    return;
                }

                if (v % 3 == 0 && ch[v / 3] == 0) {
                    Q.offer(v / 3);
                    ch[v / 3] = 1;
                }

                if (v % 2 == 0 && ch[v / 2] == 0) {
                    Q.offer(v / 2);
                    ch[v / 2] = 1;
                }

                if (ch[v - 1] == 0) {
                    Q.offer(v - 1);
                    ch[v - 1] = 1;
                }

            }

            L++;
        }


    }
}
