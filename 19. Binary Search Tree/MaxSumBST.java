public class MaxSumBST {
    static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Info{
        int max, min, sum, currmax;
        boolean isBST;
        Info(int m, int mi, boolean is, int su, int cur){
            max=m;
            min=mi;
            isBST=is;
            sum=su;
            currmax=cur;
        }
        Info(){};
    }
    static class INT{
        int a;
    }

    static Info MaxSumBSTUtil(Node root, INT maxsum){
        if (root==null){
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true,0,0);
        }
        if (root.left==null && root.right==null){
            maxsum.a=Math.max(maxsum.a, root.data);
            return new Info(root.data, root.data,true,root.data,maxsum.a);
        }
        Info L=MaxSumBSTUtil(root.left,maxsum);
        Info R=MaxSumBSTUtil(root.right, maxsum);

        Info BST=new Info();
        if (L.isBST && R.isBST && L.max<root.data && R.min>root.data){
            BST.max=Math.max(root.data, Math.max(L.max,R.max));
            BST.min=Math.min(root.data,Math.min(L.min,R.min));

            maxsum.a=Math.max(maxsum.a,R.sum+root.data+L.sum);
            BST.sum=R.sum+root.data+L.sum;
            BST.currmax=maxsum.a;
            BST.isBST=true;
            return BST;
        }
            BST.isBST=false;
            BST.currmax=maxsum.a;
            BST.sum=R.sum+root.data+L.sum;
            return BST;
    }
    static int maxSumBST(Node root){
        INT maxsum=new INT();
        maxsum.a=Integer.MIN_VALUE;
        return MaxSumBSTUtil(root,maxsum).currmax;

    }
}
