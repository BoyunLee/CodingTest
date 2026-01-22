import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=N; i>0; i--) {
			System.out.println(" ".repeat(N-i)+"*".repeat(i));
		}
	}
}