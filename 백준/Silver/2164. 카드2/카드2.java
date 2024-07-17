
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
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
