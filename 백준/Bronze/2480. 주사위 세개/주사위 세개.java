import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        int num3 = Integer.parseInt(input[2]);

        int price = 0;
        int max = 0;

        if (num1 == num2 && num2 == num3) {
            price = 10000 + num1 * 1000;    
        } else if (num1 != num2 && num2 != num3 && num1 != num3) {
            for (int i = 0; i < 3; i++) {
                if (max < Integer.parseInt(input[i])) {
                    max = Integer.parseInt(input[i]);
                }
            }
            price = max * 100;
        } else {
            if (num1 == num2 || num1 == num3) {
                price = 1000 + num1 * 100;
            } else {
                price = 1000 + num2 * 100;
            }
        }

        System.out.println(price);
    }
}