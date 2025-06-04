import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            String command = sc.nextLine();

            if(command.startsWith("push")) {
                String[] parts = command.split(" ");
                int number = Integer.parseInt(parts[1]);
                stack.push(number);
            } else if(command.equals("pop")) {
                if(!stack.isEmpty()) {
                    int popped = stack.pop();
                    sb.append(popped).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }   
            } else if(command.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if(command.equals("empty")) {
                if(!stack.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }  
            } else {
                if(!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                } 
            }
        }
        System.out.print(sb);
    }
}
