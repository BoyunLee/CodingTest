import java.util.*;

public class Main {
    static char[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        graph = new char[N][2];

        for(int i=0; i<N; i++) {
            String[] parts = sc.nextLine().split(" ");
            char parent = parts[0].charAt(0);
            graph[parent - 'A'][0] = parts[1].charAt(0);
            graph[parent - 'A'][1] = parts[2].charAt(0);
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
        System.out.println();
        sc.close();
    }

    static void preorder(char node) {
        if (node == '.') return;
        System.out.print(node);
        preorder(graph[node - 'A'][0]);
        preorder(graph[node - 'A'][1]);
    }

    static void inorder(char node) {
        if (node == '.') return;
        inorder(graph[node - 'A'][0]);
        System.out.print(node);
        inorder(graph[node - 'A'][1]);
    }

    static void postorder(char node) {
        if (node == '.') return;
        postorder(graph[node - 'A'][0]);
        postorder(graph[node - 'A'][1]);
        System.out.print(node);
    }
}
