class Node{
    int data;
    Node left, right;

    public Node(int item){
        this.data=item;
        left=right=null;
    }

}
class Solution{
    Node root;
    void mirror(){
        root=mirror(root);
    }

    Node mirror(Node node){
        if (node==null){
            return node;
        }

        Node left=mirror(node.left);
        Node right=mirror(node.right);

        node.left=right;
        node.right=left;

        return node;

//        via inorder we can print this and can call it by main function

    }
}