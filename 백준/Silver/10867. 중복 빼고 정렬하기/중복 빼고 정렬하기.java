import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int arr[] = new int[N];
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : arr) {
            treeSet.add(i);
        }


        for (int i:
                treeSet) {
            System.out.print(i + " ");
        }

    }
}
