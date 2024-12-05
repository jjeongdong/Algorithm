import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        PriorityQueue<Integer> higher = new PriorityQueue<>(); // 최소 힙

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. 새로운 숫자를 최대 힙에 추가
            if (lower.isEmpty() || num <= lower.peek()) {
                lower.add(num);
            } else {
                higher.add(num);
            }

            // 2. 힙의 크기 균형 조정
            if (lower.size() > higher.size() + 1) {
                higher.add(lower.poll());
            } else if (higher.size() > lower.size()) {
                lower.add(higher.poll());
            }

            // 3. 중간 값 출력
            sb.append(lower.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
