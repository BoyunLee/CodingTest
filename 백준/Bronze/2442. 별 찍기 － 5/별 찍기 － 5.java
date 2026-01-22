import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = 2*N -1;
		
		for(int i=0; i<N; i++) {
			System.out.println(" ".repeat(M/2-i)+"*".repeat(2*i+1));
		}
	}
}