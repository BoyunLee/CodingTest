import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] result = new int[M];

        backtrack(N, M, 0, 1, result);
        
        System.out.print(sb.toString());
    }

    public static void backtrack(int N, int M, int depth, int start, int[] result) {
    	if (depth == M) {
    	    for (int i = 0; i < M; i++) {
    	        sb.append(result[i]).append(' ');
    	    }
    	    sb.append('\n');
    	    return;
    	}
    	
        for (int i = start; i <= N; i++) {
        	result[depth] = i;
            backtrack(N, M, depth+1, i+1, result);
        }
    }
}
