import java.io.*;
import java.util.*;

public class Main{
    static int S, P;
    static int[] dna, dp;
    static char[] list = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Queue<String> q = new LinkedList<>();
        
        String arr = br.readLine();

        int result = 0;
        dna = new int[4];
        dp = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < P-1; i++) {
            q.add(arr.charAt(i) + "");
            updateDp(arr.charAt(i));
        }

        for (int i = P-1; i < S; i++) {
            q.add(arr.charAt(i) + "");
            updateDp(arr.charAt(i));
            if (check()) {
                result++;
            }
            deleteDp(q.poll().charAt(0));
        }
        


        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void updateDp(char c) {
        for (int i = 0; i < 4; i++) {
                if (c == list[i]) {
                    dp[i]++;
                }
            }
    }

    public static void deleteDp(char c) {
        for (int i = 0; i < 4; i++) {
            if (c == list[i]) {
                dp[i]--;
            }
        }
    }
    
    public static boolean check() {
        for (int i = 0; i < 4; i++) {
            if (dp[i] < dna[i]) {
                return false;
            }
        }
        return true;
    }
}