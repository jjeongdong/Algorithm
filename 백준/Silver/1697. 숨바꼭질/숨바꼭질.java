import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = 0;
        String[] arr = {"+", "-", "*"};
        Queue<Integer> Q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] ch = new int[100001];
        ch[N] = 1;
        boolean flag = false;

        Q.offer(N);

        while (!Q.isEmpty()) {

            if (flag) break;

            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int tmp = Q.poll();

                if (tmp == K) {
                    System.out.println(L);
                    flag = true;
                    break;
                }

                for (int j = 0; j < 3; j++) {
                    if (arr[j].equals("+") && tmp + 1 >= 0 && tmp + 1 < ch.length) {
                        if (ch[tmp + 1] == 0) {
                            Q.offer(tmp + 1);
                            ch[tmp + 1] = 1;
                        }
                    } else if (arr[j].equals("-") && tmp - 1 >= 0 && tmp - 1 < ch.length) {
                        if (ch[tmp - 1] == 0) {
                            Q.offer(tmp - 1);
                            ch[tmp - 1] = 1;
                        }
                    } else if (arr[j].equals("*") && tmp * 2 >= 0 && tmp * 2 < ch.length) {
                        if (ch[tmp * 2] == 0) {
                            Q.offer(tmp * 2);
                            ch[tmp * 2] = 1;
                        }
                    }

                }

            }

            L++;
        }
    }
}
