import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }
        
        Arrays.sort(array);
        
        for (int i = 0; i < num; i++) {
            System.out.println(array[i]);
        }
    }
}
