import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladderCount = Integer.parseInt(st.nextToken());
        int snakeCount = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ladderHashMap = new HashMap<>();
        HashMap<Integer, Integer> snakeHashMap = new HashMap<>();

        // 사다리 정보 입력
        for (int i = 0; i < ladderCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladderHashMap.put(start, end);
        }

        // 뱀 정보 입력
        for (int i = 0; i < snakeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snakeHashMap.put(start, end);
        }

        boolean[] visited = new boolean[101];   // 방문 정보 입력
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int answer = 0;
        boolean flag = false;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int now = queue.poll();
                if (now == 100) {
                    System.out.println(answer);
                    System.exit(0);
                }
                for (int j = 1; j <= 6; j++) {
                    int next = now + j;

                    if (next == 100) {
                        flag = true;
                        break;
                    }

                    if (!visited[next]) {
                        if (ladderHashMap.containsKey(next)) {
                            queue.add(ladderHashMap.get(next));
                            visited[ladderHashMap.get(next)] = true;
                        } else if (snakeHashMap.containsKey(next)) {
                            queue.add(snakeHashMap.get(next));
                            visited[snakeHashMap.get(next)] = true;
                        } else {
                            queue.add(next);
                            visited[next] = true;
                        }

                    }
                }

                if (flag) break;
            }

            if (flag) break;
            answer++;
        }

        System.out.println(answer + 1);
    }
}
