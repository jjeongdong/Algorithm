import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ArrayList<Character> originList = new ArrayList<>();
        HashSet<Character> remainderSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (97 <= (int) str.charAt(i) && (int) str.charAt(i) <= 122) {
                originList.add((char) ((int)str.charAt(i) - 32));
                remainderSet.add((char) ((int)str.charAt(i) - 32));
            } else {
                originList.add(str.charAt(i));
                remainderSet.add(str.charAt(i));
            }
        }

        ArrayList<Character> list = new ArrayList<>(remainderSet);

        int  maxCnt = 0;
        int cnt;
        int equalCnt = 0;
        char maxChar = ' ';
        int[] arr = new int[list.size()];


        for (int i = 0; i < list.size(); i++) {
            cnt = Collections.frequency(originList, list.get(i));
            arr[i] = cnt;

            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxChar = list.get(i);
            }
        }


        for (int i = 0; i < arr.length; i++) {
            if (Arrays.stream(arr).max().getAsInt() == arr[i]) {
                equalCnt++;
            }
        }

        if (equalCnt > 1) {
            System.out.println("?");
        } else {
            System.out.println(maxChar);
        }

    }
}

/*
Mississipi
 */