import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        for (int i = 1; i <= n; i++) {
            StringBuilder star = new StringBuilder();
            for (int j = 0; j < i; j++) {
                star.append('*');
            }
            System.out.println(star.toString());
        }
    }
}
