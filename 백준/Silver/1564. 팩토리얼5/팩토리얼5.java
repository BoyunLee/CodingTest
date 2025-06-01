import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        long num = 1;
        long modV = (long)1e12;
        for(int i = 1; i <= N; i++){
            num *= i;
            while(num%10 == 0)
                num/=10;
 
            num %= modV;
        }
 
        String tmp = Long.toString(num);
        System.out.println(tmp.substring(tmp.length()-5, tmp.length()));
    }
}