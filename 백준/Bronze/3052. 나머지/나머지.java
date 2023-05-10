import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> remainderSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            remainderSet.add(Integer.parseInt(br.readLine()) % 42);
        }


        System.out.println(remainderSet.size());
    }
}