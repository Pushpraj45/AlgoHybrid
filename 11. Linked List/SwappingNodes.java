package com.Linked;

public class SwappingNodes {
    public static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public static Node head;
    public void swapNodes(int x, int y){
        if (x==y){
            return;
        }
        Node prevX=null;
        Node currX=head;
        while(currX!=null && currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }

        Node prevY=null ;
        Node currY=head;
        while(currY!=null && currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }
        if (currX==null || currY==null){
            return;
        }
        if (prevX!=null){
            prevX.next=currY;
        }
        else{
            head=currY;
        }
        if (prevY!=null){
            prevY.next=currX;
        }
        else{
            head=currX;
        }
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;


    }
    public void push(int newdata){
        Node newNode = new Node(newdata);
        newNode.next=head;
        head=newNode;
    }
    public void printList(){
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }
    public static void main(String[] args){
        SwappingNodes ll=new SwappingNodes();
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        ll.printList();
        ll.swapNodes(4,3);
        System.out.println();
        ll.printList();
    }
}
