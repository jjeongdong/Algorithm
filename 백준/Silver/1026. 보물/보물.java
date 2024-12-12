import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		//내림차순 정렬을 하려면 int가 아닌 Integer로 선언
		Integer[] B = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
		//A 올림, B 내림
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += (A[i] * B[i]);
		}
		System.out.println(sum);
	}

}