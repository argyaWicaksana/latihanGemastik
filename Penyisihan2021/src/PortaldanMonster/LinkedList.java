package PortaldanMonster;

public class LinkedList {
    Node head;
    int size;
    byte monster;

    LinkedList(byte monster){
        head = null;
        size = 0;
        this.monster = monster;
    }

    boolean isEmpty(){
        return head==null;
    }

    void addFirst(int data){
        if (isEmpty()) {
            head = new Node(data, null);
        } else {
           Node newNode = new Node(data, head); 
           head = newNode;
        }
        size++;
    }

    int get(int index){
        Node tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
}
