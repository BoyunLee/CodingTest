import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        char[] chars = input.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'a' && ch <= 'z') {
                // 소문자를 대문자로 변환
                chars[i] = (char) (ch - 32);
            } else if (ch >= 'A' && ch <= 'Z') {
                // 대문자를 소문자로 변환
                chars[i] = (char) (ch + 32);
            }
        }
        
        String result = new String(chars);
        System.out.println(result);
    }
}
