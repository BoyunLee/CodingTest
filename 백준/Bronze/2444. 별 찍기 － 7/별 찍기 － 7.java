import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			System.out.println(" ".repeat(N-i-1)+"*".repeat(2*i+1));
		}
		
		for(int i=N-2; i>=0; i--) {
			System.out.println(" ".repeat(N-i-1)+"*".repeat(2*i+1));
		}
	}
}
