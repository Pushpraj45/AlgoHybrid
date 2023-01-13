import java.util.ArrayList;

public class Build {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root, int val){
        if (root==null){
            root=new Node(val);
            return root;
        }

        if (root.data>val){
//            left subtree
            root.left=insert(root.left, val);
        }
        else{
//            right subtree
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if (root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean Search(Node root, int key){
        if (root==null){
            return false;
        }
        if (root.data==key){
            return true;
        }

        if (root.data>key){
            return Search(root.left, key);
        }
        else{
            return Search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if (root.data<val){
            root.right=delete(root.right, val);
        }
        else if (root.data>val){
            root.left=delete(root.left, val);
        }
        else{ //voila
//            case 1 - leaf node
            if (root.left==null && root.right==null){
                return null;
            }

//            case 2 - Single child
            if (root.left==null){
                return root.right;
            }
            else if (root.right==null){
                return root.left;
            }

//            case 3 - both children
            Node IS = findInorderSuccessor(root.right); //founded inorder successor from right subtree
            root.data=IS.data; // replace value
            root.right=delete(root.right, IS.data);  // deleted inorder successor from right subtree
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void PrintInRange(Node root, int k1, int k2){
        if (root==null){
            return;
        }
        if (root.data>=k1 && root.data <=k2){
            PrintInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            PrintInRange(root.right, k1, k2);
        }
        else if (root.data<k1){
            PrintInRange(root.left, k1, k2);
        }
        else {
            PrintInRange(root.right, k1, k2);
        }
    }

    public static void PrintPath(ArrayList<Integer> path){
        for (int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root==null){
            return;
        }


        path.add(root.data);
        if (root.left==null && root.right==null){
            PrintPath(path);
        }
        printRoot2Leaf(root.left,path);
        printRoot2Leaf(root.right,path);
        path.remove(path.size()-1); //data exists in last index
    }

    public static boolean isvalidBST(Node root, Node min, Node max){
        if (root==null){
            return true;
        }
        if (min!=null && root.data<=min.data){
            return false;
        }
        else if (max!=null && root.data>=max.data){
            return false;
        }
        return isvalidBST(root.left, min, root) && isvalidBST(root.right,root,max);
    }

    public static Node mirror(Node root){
        if (root==null){
            return null;
        }
        Node leftS=mirror(root.left);
        Node rightS=mirror(root.right);

        root.left=rightS;
        root.right=leftS;

        return root;
    }
    public static void preorder(Node root){
        if (root==null){
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node SortedArrayToBST(int[] arr , int start, int end){
        if (start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node root=new Node(arr[mid]);
        root.left=SortedArrayToBST(arr,start,mid-1);
        root.right=SortedArrayToBST(arr,mid+1,end);
        return root;
    }
    public static void main(String[] args){
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for (int i=0; i<values.length; i++){
            root=insert(root, values[i]);
        }

//        confirming the things
        inorder(root);
        System.out.println();

        if (Search(root,1)){
            System.out.println("Found ");
        }
        else {
            System.out.println("not found ");
        }

        root=delete(root,1);
        System.out.println();
        inorder(root);

        PrintInRange(root,5,11);
        printRoot2Leaf(root,new ArrayList<>());

        if (isvalidBST(root,null,null)){
            System.out.println("valid");
        }
        else {
            System.out.println("not valid ");
        }

        int arr[]={3,4,5,6,7,8,9,10};
        Node roott=SortedArrayToBST(arr,0,arr.length-1);
        preorder(roott);
    }
}
