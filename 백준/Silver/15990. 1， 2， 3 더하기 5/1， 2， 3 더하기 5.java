import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class  Cnt {
    long cnt1;
    long cnt2;
    long cnt3;

    public Cnt(long cnt1, long cnt2, long cnt3) {
        this.cnt1 = cnt1;
        this.cnt2 = cnt2;
        this.cnt3 = cnt3;
    }
}

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        List<Cnt> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list.add(new Cnt(1, 0, 0));
        list.add(new Cnt(0, 1, 0));
        list.add(new Cnt(1, 1, 1));

        for (int i = 3; i <= 1000000; i++) {
            long i1 = (list.get(i - 3).cnt1 + list.get(i - 3).cnt2) % 1000000009;
            long i2 = (list.get(i - 2).cnt1 + list.get(i - 2).cnt3) % 1000000009;
            long i3 = (list.get(i - 1).cnt2 + list.get(i - 1).cnt3) % 1000000009;

            list.add(new Cnt(i3, i2, i1));
        }

        for (int tmp : arr) {
            System.out.println((list.get(tmp - 1).cnt1 + list.get(tmp - 1).cnt2 + list.get(tmp - 1).cnt3) % 1000000009);
        }


    }
}
