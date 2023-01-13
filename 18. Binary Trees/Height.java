import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Height {
    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        System.out.println(height(root));
        System.out.println(count(root));

        System.out.println(sum(root));

        System.out.println(diameter(root));
        System.out.println(diameter2(root).diam);
        System.out.println(diameter2(root).ht);

        System.out.println(isSubtree(root,subRoot));

        TopView(root);
        Kelevel(root,3,2);
        System.out.println(lca(root,4,7).data);

        int n1=4, n2=7;
        System.out.println(minDist(root,n1,n2));

        Transform(root);
        preorder(root);

    }
    public static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static int height(Node root){  // helper function
        if(root==null){
            return 0;
        }

        int  lh=height(root.left);
        int rh=height(root.right);
        return Math.max(rh,lh)+1;
    }

    public static int count(Node root){
        if (root==null){
            return 0;
        }

        int leftcount=count(root.left);
        int rightcount=count(root.right);

        return leftcount+rightcount+1;
    }

    public static int sum(Node root){
        if (root==null){
            return 0;
        }

        int leftsum=sum(root.left);
        int rightsum=sum(root.right);

        return leftsum+rightsum+ root.data;
    }
    public static int diameter(Node root){
        if (root==null){
            return 0;
        }
        int leftdiam=diameter(root.left);
        int rightdiam=diameter(root.right);
        int lh=height(root.left);
        int rh=height(root.right);

        int selfdiam=lh+rh+1;

        return Math.max(selfdiam,Math.max(leftdiam,rightdiam)); // as max cannot calculate three values at a time

    }

//    Approach-2 O(n)

    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter2(Node root){
        if (root==null){
            return new Info(0,0);
        }
        Info leftInfo=diameter2(root.left);
        Info rightInfo=diameter2(root.right);

        int diam=Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+ rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;

        return new Info(diam, ht);

    }
    public static boolean isIdentical(Node node, Node subRoot){
        if (node==null && subRoot==null){
            return true;
        }
        else if (node==null || subRoot==null || node.data!=subRoot.data){
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot){
        if (root==null){
            return false;
        }
        if (root.data==subRoot.data){
            if (isIdentical(root,subRoot)){
                return true;
            }
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right, subRoot);
    }
    static class Information{
        Node node;
        int hd;

        public Information(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void TopView(Node root){
//        Level Order
        Queue<Information> q=new LinkedList<>();
        HashMap<Integer, Node> map= new HashMap<>();

        int min=0, max=0;
        q.add(new Information(root,0));
        q.add(null);

        while (!q.isEmpty()){
            Information curr=q.remove();
            if (curr==null){
                if (q.isEmpty()){
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {

            if (!map.containsKey(curr.hd)){ //first time my hd is occurring
                map.put(curr.hd, curr.node);
            }

            if (!map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left!=null){
                q.add(new Information(curr.node.left, curr.hd-1));
                min=Math.min(min, curr.hd-1);
            }

            if (curr.node.left!=null){
                q.add(new Information(curr.node.right, curr.hd+1));
                max=Math.max(max, curr.hd+1);
            }
        }
        }
        for (int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();

    }

    public static void Kelevel(Node root, int level , int k){
        if (root==null){
            return;
        }

        if (level==k){
            System.out.println(root.data);
            return;
        }
        Kelevel(root.left, level+1, k);
        Kelevel(root.right, level+1, k);
//        can call from main function and print

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if (root==null){
            return false;
        }

        path.add(root);

        if (root.data == n){
            return true;
        }

        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);

        if (foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for (; i<path1.size() && i< path2.size(); i++){
            if (path1.get(i)!=path2.get(i)){
                break;
            }
        }
//        last equal node -> i-1st
        Node lca=path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2){
        if (root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftLca=lca2(root.left, n1, n2);
        Node rightLca=lca2(root.right, n1, n2);

//        leftLca=val rightLca=null

        if (rightLca==null){
            return  leftLca;
        }

        if (leftLca==null){
            return rightLca;
        }

        return root; // mein hi ancestor hu
    }

    public static int lcaDist(Node root, int n){
        if (root==null){
            return -1;
        }
        if (root.data==n){
            return 0; // overlap same condition
        }

        int leftDist=lcaDist(root.left,n);
        int rightDist=lcaDist(root.right,n);

        if (leftDist==-1 && rightDist==-1){
            return -1;
        }
        else if (leftDist==-1){
            return rightDist+1;
        }
        else{
            return leftDist+1;
        }
    }
    public static int minDist(Node root, int n1, int n2){
        Node lca=lca2(root, n1, n2);
        int dist1 = lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);

        return dist1+dist2;
    }
    public static int Kancestor(Node root, int n, int k){
        if (root==null){
            return -1;
        }

        if (root.data==n){
            return 0;
        }

        int leftDist=Kancestor(root.right, n, k);
        int rightDist=Kancestor(root.left, n, k);

        if (leftDist==-1 && rightDist==-1){
            return -1;
        }

        int max=Math.max(leftDist,rightDist); // valid distance
        if (max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int Transform(Node root){
        if (root==null){
            return 0;
        }

        int leftChild= Transform(root.left);
        int rightChild= Transform(root.right);

        int data=root.data;
        int newLeft=root.left==null? 0: root.left.data;
        int newRight=root.right==null?0: root.right.data;
        root.data=newLeft+leftChild+newRight+rightChild;
        return data;
    }

    public static void preorder(Node root){
        if (root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}
