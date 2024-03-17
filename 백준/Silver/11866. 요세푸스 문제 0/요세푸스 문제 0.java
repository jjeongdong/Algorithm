import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(str.nextToken());
        int N = Integer.parseInt(str.nextToken());

        StringBuilder answer = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            queue.offer(i + 1);
        }

        answer.append('<');
        for (int i = 0; i < size - 1; i++) {
            for (int j = 1; j < N; j++) {
                queue.offer(queue.poll());
            }

            answer.append(queue.poll()).append(", ");
        }

        answer.append(queue.poll());
        answer.append('>');
        System.out.println(answer);
    }
}
