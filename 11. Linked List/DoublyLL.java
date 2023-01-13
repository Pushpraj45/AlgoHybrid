package com.Linked;

public class DoublyLL {
public class Node{
    int data;
    Node next;
    Node prev;
    public Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
public static Node head;
public static Node tail;
public static int size;

// Add first
    public void AddFirst(int data){
        Node newNode=new Node(data);
        size++;
        if (head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

//    Print
    public void print(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

//    Remove operation
    public int removeFirst(){
        if (head==null){
            System.out.println("Doubly Linked list is empty ");
            return Integer.MIN_VALUE;
        }

        if (size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }

        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        System.out.println("Removed value is "+val);

        return val;
    }

//    Reverse a DoublyLL
    public void Reverse(){
        Node curr=head;
        Node prev=null;
        Node next;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;

            prev=curr;
            curr=next;
        }
        head=prev;
    }

//    Finding a element - Traversal
    public int itrSearch(int key){ // O(n)
        if (head==null){
            System.out.println("LL is empty ");
            return Integer.MIN_VALUE;
        }
        Node temp=head;
    int i=0;
    while(temp!=null){
        if (temp.data==key){  // Key found
            System.out.println("The Node is present on the index ");
            return i;
        }
        temp=temp.next;
        i++;
    }
        return -1;
    }

    public static void main(String[] args){
        DoublyLL dll=new DoublyLL();
        System.out.println("Creation of Doubly LL ");
        dll.AddFirst(1);
        dll.AddFirst(2);
        dll.AddFirst(3);
        dll.AddFirst(4);

        dll.print();
        System.out.println("The size of the Doubly LL is "+ dll.size);

        dll.removeFirst();
        dll.print();

        System.out.println(dll.itrSearch(1));

//        dll.Reverse();
//        dll.print();

    }
}
