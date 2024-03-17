import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[num1];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st1.nextToken());
        }

        int num2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[num2];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr1);



        for (int i = 0; i < arr2.length; i++) {

            int lt = 0;
            int rt = arr1.length - 1;

            while (lt <= rt) {
                int mid = (lt + rt) / 2;

                if (arr1[mid] == arr2[i]) {
                    System.out.print(1 + " ");
                    break;
                }

                if (arr1[mid] < arr2[i]) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }

                if (lt > rt) {
                    System.out.print(0 + " ");
                }
            }
        }

    }
}
