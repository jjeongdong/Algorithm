import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
9 8
CCTGGATTG
2 0 1 1
 */

public class Main {
    static int[] myArr = new int[4];
    static int[] checkArr = new int[4];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N ; i++) {
            queue.add(i);
        }

        while (true) {
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }

            queue.poll();
            queue.add(queue.poll());
        }
    }
}
