package com.Linked;

public class DeleteNafterM {
    public static class Node{
        int data;
        Node next;

    }
    public static Node head;
    static Node push(Node head, int newdata){
        Node newNode=new Node();
        newNode.data=newdata;
        newNode.next=head;
        head=newNode;
        return head;
    }

    static void PrintList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println(" ");
    }

    public static void SkipMdeleteN(Node head, int m, int n){
        Node curr=head;
        Node t;
        int count;
        while(curr!=null){
            for (count=1; count<m && curr!=null ; count++){
                curr=curr.next;

                if(curr==null){
                    return ;
                }
                    t=curr.next;
                    for (count=1; count<=n && t!=null ; count++){
                        Node temp=t;
                        t=t.next;
                    }
                    curr.next=t;
                    curr=t;
            }
        }
    }
    public static void main(String[] args){
        Node head=null;
        int m=2, n=3;
        head=push(head,10);
        head=push(head,9);
        head=push(head,8);
        head=push(head,7);
        head=push(head,6);
        head=push(head,5);
        head=push(head,4);
        head=push(head,3);
        head=push(head,2);
        head=push(head,1);

        PrintList(head);
        SkipMdeleteN(head,m,n);
        PrintList(head);
    }
}
