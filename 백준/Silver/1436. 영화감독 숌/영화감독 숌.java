import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tmp = 666;
        int index = 1;

        while (true) {
            if (String.valueOf(tmp).contains("666")) {
                if (index == N) break;
                else index++;
            }
            tmp++;
        }

        System.out.println(tmp);
    }
}
