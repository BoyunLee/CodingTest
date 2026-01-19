import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // int n1 = sc.nextInt();
        // int n2 = sc.nextInt();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        
        int a = n1;
        int b = n2;
        
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        
        int max = (n1/a)*(n2/a)*a;
        
        System.out.println(a);
        System.out.println(max);
    }
}