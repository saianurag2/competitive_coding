import java.util.Scanner;
class WordDictionary2 {
    public static Lexon root;
    class Lexon{
        char c;
        boolean endOfWord;
        Lexon[] nextInLine;
        public Lexon(char ch){
            this.c = ch;
            nextInLine = new Lexon[26];
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary2() {
       root = new Lexon('*'); 
    }
    public Lexon mergeLexons(Lexon l1, Lexon l2){
        if( l1 != null & l2 != null){
            Lexon l3;
            if(l1.c == l2.c)
                 l3 = new Lexon(l1.c);
            else
                l3 = new Lexon('.');
            if(l1.endOfWord || l2.endOfWord)
                l3.endOfWord = true;
            for(int i = 0; i < 26;i++){
                if(l2.nextInLine[i] == null && l1.nextInLine[i] == null)
                    l3.nextInLine[i] = null;
                else if(l2.nextInLine[i] != null && l1.nextInLine[i] != null){
                    l3.nextInLine[i] = mergeLexons(l1.nextInLine[i],l2.nextInLine[i]);
                    if(l1.nextInLine[i].endOfWord || l2.nextInLine[i].endOfWord )
                        l3.nextInLine[i].endOfWord = true;
                }
                else if(l1.nextInLine[i] == null && l2.nextInLine[i] != null){
                    l3.nextInLine[i] = l2.nextInLine[i];
                    l3.nextInLine[i].endOfWord = l2.nextInLine[i].endOfWord;
                }
                else {//if(l1.nextInLine[i] != null && l2.nextInLine[i] == null){
                    l3.nextInLine[i] = l1.nextInLine[i];
                    l3.nextInLine[i].endOfWord = l1.nextInLine[i].endOfWord;
                }
            }
            return l3;
        }else if(l2 != null)
            return l2;
        else if(l1 != null)
            return l1;
        return null;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word == "") return;
        int l = word.length(); 
        Lexon p = root;
        for(int i = 0; i < l; i++){
            if(p.nextInLine[word.charAt(i)-'a'] == null){
                p.nextInLine[word.charAt(i)-'a'] = new Lexon(word.charAt(i));
            }
            p = p.nextInLine[word.charAt(i)-'a'];
        }
        p.endOfWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word == "") return false;
        int l = word.length();
        int i = 0;
        // Lexon[] p = root.nextInLine;
        Lexon p = root;
        for(; i < l; i++){
            if(p == null) return false;
            // if(i == l-1){
            //     if(word.charAt(i) == '.'){
            //         for(Lexon leaf: p.nextInLine)//p
            //             if(leaf != null && leaf.endOfWord){
            //                 System.out.println(leaf.c);
            //                 return true;
            //             }
            //     }
            //     // else if(p[word.charAt(i)-'a'] != null & p[word.charAt(i)-'a'].endOfWord)
            //     else if(p.nextInLine[word.charAt(i)-'a'] != null && p.nextInLine[word.charAt(i)-'a'].endOfWord)
            //         return true;
            //     return false;
            // }
            if(word.charAt(i) == '.'){
                Lexon p2 = null;
                for(Lexon lex: p.nextInLine){//p
                    if(lex != null)
                        p2 = mergeLexons(p2,lex);
                }
                if(p2 == null) return false;
                p = p2; //p2.nextInLine;     
            }else{
                if(p.nextInLine[word.charAt(i)-'a'] == null)
                    return false;
                p = p.nextInLine[word.charAt(i)-'a'];//.nextInLine;
            }
        }
        if(p.endOfWord)
            return true;
        return false;
    }
    public static void main(String []args){
        WordDictionary2 obj = new WordDictionary2();
        // // ["at"],["and"],["an"],["add"],["a"]
        String[] wordList = {"at", "and", "an", "add"};
        // [".at"],["an."],["a.d."],["b."],["a.d"],["."]
        String[] searchList = {"a", ".at", "an.", "a.d.",".", "ba", "aa"};
        // for(String word : wordList){
        //     obj.addWord(word);
        //     System.out.print("A: "+word+" ");
        // }
        // System.out.println();
        // System.out.println("S: "+".at"+ " "+obj.search(".at"));
        // obj.addWord("bat");
        // System.out.println("A: bat ");
        // for(String query : searchList){
        //     System.out.println("S: "+query+ " "+obj.search(query));
        // }
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println(" 1 Add , 2 Search, Def: exit");
            int action = scan.nextInt();
            String word;
            switch(action){
                case 1: System.out.println("Enter word to add");
                        word = scan.next();
                        obj.addWord(word);
                        break;
                case 2: System.out.println("Enter word to search");
                        word = scan.next();
                        System.out.println("Search "+word+ " "+obj.search(word));
                        break;
                default: flag = false;
                        System.out.println("Exit success");
            }
        }
        scan.close();
    }
}
