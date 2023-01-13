public class LinkedList {
    public static class Node{
        int data;
        Node next; // Node type because it is going to point or referring in other node
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; // By default java set it's value to 0

    public void AddFirst(int data){  // O(1)
//      Step1 => Create new Node
        Node newNode=new Node(data);
        size++;
        if (head==null){
        head=tail=newNode;
        return;
}
//      Step2 => NewNode next = head
        newNode.next=head; // Link

//      Step3 => head = newNode
        head=newNode;
    }
    public void AddLast(int data){
        Node newNode=new Node(data);
        size++;
        if (head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        if (head==null){
            System.out.println("LL is empty ");
            return;
        }
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void Add(int idx, int data){
        if (idx==0){
            AddFirst(data);
        }

        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
//        i=idx-1; temp->prev
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
//      Two special cases
        if (size==0){
            System.out.println("LL is empty ");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head= head.next;
        size--;
        return val;
    }
    public int RemoveLast(){
        if (size==0){
            System.out.println("LL is empty ");
            return Integer.MIN_VALUE;
        }
        else if (size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
//        prev : i=size-2
        Node prev=head;
        for (int i=0; i<size-2; i++){
            prev=prev.next;
        }
        int val=prev.next.data; //tail.data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }
    public int itrSearch(int key){ // O(n)
        Node temp=head;
        int i=0;
        while(temp!=null){
            if (temp.data==key){  // Key found
                return i;
            }
            temp=temp.next;
            i++;
        }
//        Key not found
        return -1;
    }
    public int helper(Node head, int key){
        if (head==null){
            return -1;
        }
        if (head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if (idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int RSearch(int key)
    {
        return helper(head,key);
    }

//    Classical one and important Question
//    1->2->3->4->5->null
//    null<-1<-2<-3<-4<-5

//    Reversing a Linked List
    public void Reverse(){
        Node prev=null;
        Node curr=tail=head; // Right to left assignment in java
        Node next;   // 3 variables 4 steps
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

//    Find and Remove Nth Node from End
//    Iterative Approach - O(n)
    public void deleteNthfromEnd(int n){
//        Calculate size
        int sz=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            sz++;
        }
//        if we want to delete head node
        if (n==sz){
            head=head.next; //remove first
            return;
        }
//        sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while (i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
//    Checking if a LL is a palindrome
//    Step Wise performing -
//    Creating function to find mid node
    public Node FindMid(Node head){
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next;  //+2

        }
        return slow;// slow is my MidNode
    }
    public boolean checkPalindrome(){
        if (head==null || head.next==null){
            return true;
        }
//        Step-1 findMid Node
        Node midNode=FindMid(head);
//        Step-2 Reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev; //right half head
        Node left=head;

//        Step-3 Check left and right half
        while (right!=null){
            if (left.data!= right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static boolean Iscycle(){  // Floyd's cycle Finding Algorithm - slow fast approach
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return true; // Cycle exists
            }
        }
        return false;  // Cycle doesn't exist
    }

    public static void RemoveCycle(){
//        Detect Cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                cycle=true;
                break;
            }
        }
        if (cycle==false){
            return;
        }
//        Find meeting point
        slow=head;
        Node prev=null; //last node
        while (slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

//        Remove cycle -> last.next=null
        prev.next=null;
    }

//    Merge sort on a linked list
//    Finding Mid
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; // mid Node
    }

//    Merge Function for merging linked list
    public Node merge(Node head1, Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while (head1!=null && head2!=null){ // Comparing and then merging
            if (head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
//        Loop for remaining part from both side
        while (head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while (head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergedLL.next; // as -1 is stored as dummy node in LL
    }
    public Node mergeSort(Node head){
        if (head==null || head.next==null){
            return head;
        }
//      Find Mid
        Node mid=getMid(head);

//      left and right MS
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);

//      merge
        return merge(newLeft, newRight);

    }

    public void ZigZag(){
//        Find mid
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid = slow;
//        Reverse 2nd Half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

//        Alt merge - Zig-zag merge
        while (left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;

        }
    }
        public static void main(String[] args){
        LinkedList ll=new LinkedList();
        //        ll.head=new Node(1);
//        ll.head.next=new Node(2); this way we can create head and insert data in it

        ll.AddFirst(5);
        ll.AddFirst(4);
        ll.AddLast(3);
        ll.AddLast(2);
//        ll.Add(2,9);
        ll.AddFirst(1);
//        ll.AddFirst(2);
//        ll.AddFirst(5);
        ll.print();
//        ll.removeFirst();
//        ll.print();
//        ll.RemoveLast();
//        ll.print();
//        System.out.println("Size of the Linked list is "+size);
//
//        System.out.println(ll.itrSearch(3));
//        System.out.println(ll.itrSearch(10));

//        ll.Reverse();
//
        ll.deleteNthfromEnd(2);
        ll.print();

//        For Palindrome
//        ll.AddLast(1);
//        ll.AddLast(2);
//        ll.AddLast(2);
//        ll.AddLast(1);
//        ll.print();
//        System.out.println(ll.checkPalindrome());

//        For detecting cycle in a loop
//            head=new Node(1);
//            head.next=new Node(2);
//            Node temp=new Node(2);
//            head.next.next=new Node(3);
//            head.next.next.next=head;
//            1->2->3->1 cycle exist
//        System.out.println(Iscycle());

//      For removing the cycle ->
//        head=new Node(1);
//        Node temp=new Node(2);
//        head.next=temp;
//        head.next.next=new Node(3);
//        head.next.next.next=temp;
//        System.out.println(Iscycle());
//        RemoveCycle();
//        System.out.println(Iscycle());

//            Merge Sort in the Linked list
//            li.AddFirst(1);
//            li.AddFirst(2);
//            li.AddFirst(3);
//            li.AddFirst(4);
//            li.AddFirst(5);
//            li.AddFirst(6);

//      This linked list is sorted in reverse order
//            li.print();
//            li.head=li.mergeSort(li.head);
//            ll.print();

//            TC=O(nlogn)

//            Code for Zig Zag Linked List

//            LinkedList li=new LinkedList();
//
//            li.AddFirst(1);
//            li.AddFirst(2);
//            li.AddFirst(3);
//            li.AddFirst(4);
//            li.AddFirst(5);
//            li.AddFirst(6);
//            li.print();
//            li.ZigZag();
//            li.print();
    }
}
