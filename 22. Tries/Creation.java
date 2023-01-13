public class Creation {

    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;

        Node(){
            for (int i=0; i<26; i++){
                children[i]=null;
            }
        }
    }

    public static Node root=new Node(); //by default it's empty

    public static void insert(String word){
        Node curr=root;
        for (int level=0; level<word.length(); level++){ //O(L)
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
    }

    public static boolean search(String key){
        Node curr=root;
        for (int level=0; level<key.length(); level++){
            int idx=key.charAt(level)-'a';
            if (curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }

    public static boolean startsWith(String prefix){
        Node curr=root;
        for (int level=0; level<prefix.length(); level++){
            int idx=prefix.charAt(level)-'a';
            if (curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args){
        String words[]={"the", "a", "their", "any", "thee"};
        for (int i=0; i< words.length; i++){ //created a trie for array of words
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(startsWith("the"));
    }
}
