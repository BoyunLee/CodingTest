import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = a.replaceAll(" ", "");
        String d = b.replaceAll(" ", "");
        
        System.out.print(c);
        System.out.print(d);
    }
}