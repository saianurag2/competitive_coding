
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class FlattenDoublyLList {
    private void flattenChild(Node parent){
        Node nxt = parent.next;
        if(parent.child.child != null){
            flattenChild(parent.child);
        }
        parent.child.prev = parent;
        parent.next =  parent.child;
        Node eol;
        if(parent.child.next !=null){
             eol = parent.child;
            while(eol.next !=null){
                eol = eol.next;
            }
        }else
            eol = null;
        if(eol == null){
            parent.child.next = nxt;
            if(nxt != null)
                nxt.prev = parent.child;
        }
        else{
            eol.next = nxt;
            if(nxt != null)
                nxt.prev = eol;
        }
        parent.child = null;
        return;
        
    }
    public Node flatten(Node head) {
        if(head == null)
            return head;
        Node temp = head;
        // Node nxtHold;
        while(temp !=null){
                if(temp.child != null)
                    flattenChild(temp);
            temp = temp.next;      
            }
        return head;
        }
    
}