import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, R, C;
    static String[][][] board;
    static boolean[][][] visit;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    list.add(num);
                }
            }

            if (list.size() != 3) {
                break;
            }

            Collections.sort(list);
            T.solution(list, sb);
        }

        System.out.println(sb);

    }

    private void solution(List<Integer> list, StringBuilder sb) {
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);

        if (c * c == (a * a) + (b * b)) {
            sb.append("right").append("\n");
        } else {
            sb.append("wrong").append("\n");
        }
    }
}
