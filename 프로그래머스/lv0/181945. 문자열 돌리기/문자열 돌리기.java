import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String[] array = a.split("");
        
        for(String word : array) {
            System.out.println(word);
        }
    }
}