public class KthSmallestElement {
    static class Node{
        int data;
        Node left, right;
        Node(int x){
            data=x;
            left=right=null;
        }
    }
    static int count=0;
    public static Node insert(Node root, int x){
        if (root==null){
            return new Node(x);
        }
            if (x<root.data){
                root.left=insert(root.left,x);
            }
            else if (x>root.data){
                root.right=insert(root.right,x);
            }
            return root;
        }
    public static Node KthSmallest(Node root, int k){
        if (root==null){
            return null;
        }
        Node left=KthSmallest(root.left,k);
        if (left!=null){
            return left;
        }
        count++;
        if (count==k){
            return root;
        }
        return KthSmallest(root.right,k);
    }
    public static void main(String[] args ){

    }
}
