import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(Character.toUpperCase(ch));
            }
        }
        
        System.out.println(result.toString());
    }
}
