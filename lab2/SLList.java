public class SLList{
    public static class IntNode {
        public int item;
        public IntNode next;
        // constructor
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }        
    }
    
    private IntNode first;
    private int size;
    
    public SLList(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    // Add an item to the front of the list
    public void addFirst(int x){
        first = new IntNode(x, first);
        size += 1;
    }

    // Retrieves the front item from the list
    public int getFirst(){
        return first.item;
    }

    // Add an item to the end of the list
    public void addLast(int x){
        IntNode p = first;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        // Create a list of one integer
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(13);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}