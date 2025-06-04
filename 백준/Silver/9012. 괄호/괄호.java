import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            String text = sc.next();

            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for(int j=0; j<text.length(); j++) {
                char c = text.charAt(j);

                if(c == '(' ) {
                    stack.push(c);
                } else {
                    if(!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if(isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }   
        }
    }
}
