package PortaldanMonster;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N, K, a, b;
        byte monster;
        try (Scanner sc = new Scanner(System.in)) {
            N = sc.nextInt(); //byk sarang monster
            K = sc.nextInt(); //byk terowongan
            Graph graph = new Graph(N);
            for (int i = 0; i < N; i++) {
                monster = sc.nextByte();
                graph.totalMonster(i, monster);
            }

            // for (int i = 0; i < N; i++) {
            //     System.out.println("Sarang ke-"+(i+1)+" punya "+graph.getMonster(i)+" monster");
            // }
            // System.out.println();

            for (int i = 0; i < K; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                graph.addEdge(a-1, b-1);
            }
            // graph.printGraph();

            System.out.println(graph.minEnergy());
        }

    }
    
}


class Node {
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

}

//kurang sempurna