import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		 
		int total = N*2-1;
		
		for (int i = 0; i < total; i++) {

            if (i == 0 || i == total - 1) {
                for (int j = 0; j < N; j++) System.out.print("*");
                for (int j = 0; j < 2 * N - 3; j++) System.out.print(" ");
                for (int j = 0; j < N; j++) System.out.print("*");
                System.out.println();
                continue;
            }

            if (i == N - 1) {
                for (int j = 0; j < N - 1; j++) System.out.print(" ");
                System.out.print("*");
                for (int j = 0; j < N - 2; j++) System.out.print(" ");
                System.out.print("*");
                for (int j = 0; j < N - 2; j++) System.out.print(" ");
                System.out.println("*");
                continue;
            }
            
            int outer = (N - 1) - Math.abs(N - 1 - i);

            for (int j = 0; j < outer; j++) System.out.print(" ");
            System.out.print("*");

            for (int j = 0; j < N - 2; j++) System.out.print(" ");
            System.out.print("*");

            for (int j = 0; j < 2 * Math.abs(N - 1 - i) - 1; j++) System.out.print(" ");
            System.out.print("*");

            for (int j = 0; j < N - 2; j++) System.out.print(" ");
            System.out.println("*");
        }
	}
}
