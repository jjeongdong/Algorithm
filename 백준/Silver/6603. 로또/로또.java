import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            arr = new int[N];
            result = new int[6];
            visited = new boolean[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append("\n");
        }

       System.out.print(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i  = start; i < N; i++) {
            if(!visited[i]) {
                result[depth] = arr[i];
                visited[i] = true;
                dfs(i + 1, depth  + 1);
                visited[i] = false;
            }
        }
    }
}