public class MaxSum {
    class Node{
        int data;
        Node left, right;

        public Node(int item){
            data=item;
            left=right=null;
        }
    }

    class Res{
        public int val;
    }

    class Solution{
        Node root;
        int findMaxUtil(Node node, Res res){
            if (node==null){
                return 0;
            }

            int l=findMaxUtil(node.left,res);
            int r=findMaxUtil(node.right,res);

            int max_single=Math.max(Math.max(l,r)+node.data,node.data);

            int max_top=Math.max(max_single, l+r+node.data);

            res.val=Math.max(res.val, max_top);

            return max_single;
        }

//        int findMaxSum(){
//            return findMaxSum(root);
//        }

        int findMaxSum(Node node){
            Res res=new Res();
            res.val=Integer.MIN_VALUE;

            findMaxUtil(node,res);
            return res.val;
        }
    }

}
