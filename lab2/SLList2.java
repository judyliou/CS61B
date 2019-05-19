public class SLList2{
    public static class IntNode {
        public int item;
        public IntNode next;
        // constructor
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }        
    }
    
    private IntNode sentinel;
    private int size;
    
    // Create an empty SLList
    public SLList2() {
        sentinel = new IntNode(100, null);
        size = 0;
    }

    public SLList2(int x) {
        sentinel = new IntNode(100, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList2(int[] x) {
        sentinel = new IntNode(100, null);
        IntNode cur = sentinel;
        for (int i = 0; i < x.length; i++){
            cur.next = new IntNode(x[i], null);
            cur = cur.next;
            size += 1;
        }
    }

    // Add an item to the front of the list
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    // Delete the first item
    public void deleteFirst(){
        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    // Retrieves the front item from the list
    public int getFirst(){
        return sentinel.next.item;
    }

    // Add an item to the end of the list
    public void addLast(int x){
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

    // Retrieves the last item from the list
    public int getLast() {
        IntNode cur = sentinel;
        for (int i = 0; i < size; i++){
            cur = cur.next;
        }
        return cur.item;
    }


    public int size(){
        return size;
    }

    public static void main(String[] args){
        // Create a list of one integer
        int[] arr = {1, 2, 4, 6, 29};
        SLList2 L = new SLList2(arr);
        System.out.println(L.size());
        System.out.println(L.getFirst());
        L.addFirst(77);
        System.out.println(L.getFirst());
        L.deleteFirst();
        System.out.println(L.getFirst());
        L.addLast(13);
        System.out.println(L.getLast());
        System.out.println(L.size());
    }
}