public class ClosestElement {

    static int mindiff, mindiffkey;
    static class Node{
        int key;
        Node left, right;
    }

    static Node newNode(int key){
        Node node=new Node();
        node.key=key;
        node.left=node.right=null;
        return node;
    }

    static void maxdiffUtil(Node ptr, int k){
        if (ptr==null){
            return;
        }
        if (ptr.key==k){
            mindiffkey=k;
            return;
        }

        if (mindiff>Math.abs(ptr.key-k)){
             mindiff=Math.abs(ptr.key-k);
             mindiffkey=ptr.key;
        }

        if (k<ptr.key){
            maxdiffUtil(ptr.left,k);
        }
        else {
            maxdiffUtil(ptr.right, k);
        }
    }

    static int maxdiff(Node root, int k){
        mindiff=99999999;
        mindiffkey=-1;
        maxdiffUtil(root,k);
        return mindiffkey;
    }

    public static void main(String[] args){
        Node root=newNode(9);
        root.left=newNode(4);
        root.right=newNode(17);
        root.left.left=newNode(3);
        root.left.right=newNode(6);
        root.left.right.left=newNode(5);
        root.left.right.right=newNode(7);
        root.right.right=newNode(22);
        root.right.right.left=newNode(20);
        int k=18;
        System.out.println(maxdiff(root,k));
    }
}
