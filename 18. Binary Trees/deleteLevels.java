public class deleteLevels {

    static class Node{
        int data;
        Node left, right;
    }
    static Node newNode(int data){
        Node newNode=new Node();
        newNode.data=data;
        newNode.left=null;
        newNode.right=null;
        return newNode;
    }
    static Node delete(Node root, int x){
        if (root==null){
            return null;
        }
        root.left=delete(root.left,x);
        root.right=delete(root.right,x);

        if (root.data==x && root.left==null && root.right==null){
            return null;
        }
        return root;
    }

//    via inorder we can print this
    public static void main(String[] args){
        Node root=newNode(10);

//        can make more and print them

    }
}
