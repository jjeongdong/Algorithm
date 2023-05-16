import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.print(solution(n));
	}
	
	private static int solution(int n) {
		if(n == 1) return 1;
		int i=2;
		int k=1;
		
		while(i<=n) {
			i += 6*k++;
		}
		
		return k;
	}
}
