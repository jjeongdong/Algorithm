import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            list.add(new Person(weight, height));
        }

        for (int i = 0; i < list.size(); i++) {
            int cnt = 1;
            Person person = list.get(i);

            for (int j = 0; j < list.size(); j++) {
                if (person.weight < list.get(j).weight && person.height < list.get(j).height) {
                    cnt++;
                }
            }


            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
