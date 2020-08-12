class Trie {
    Node root;
    
    class Node{
        char letter;
        Node []children = new Node[26];
        boolean endOfWord;
        public Node(char c){
            letter = c;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('*');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word == "") return;
        int l = word.length(); 
        Node parent = this.root;
        for(int i = 0; i < l; i++){
            if(parent.children[word.charAt(i)-'a'] == null){
                parent.children[word.charAt(i)-'a'] = new Node(word.charAt(i));
            }
            parent = parent.children[word.charAt(i)-'a'];
        }
        parent.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word == "") return false;
        Node last =  this.getLastChar(word);
        if(last == null) return false;
        if(last.endOfWord && last.letter == word.charAt(word.length()-1)) return true;
        return false;
    }
    
    public Node getLastChar(String word) {
        int l = word.length();
        Node parent = this.root;
        for(int i = 0; i < l; i++){
            if(parent.children[word.charAt(i)-'a'] == null)
                return null;
            parent = parent.children[word.charAt(i)-'a'];
        }
        return parent;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix == "") return false;
        Node last = this.getLastChar(prefix);
        if(last == null) return false;
        if(last.letter == prefix.charAt(prefix.length()-1))
            return true;
        return false;
    }

    public static void main(String []args){
        // Your Trie object will be instantiated and called as such:
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("apple");
    }
}




 