public class Sort {
    public static void sort(String[] x) {
        sort(x, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length){
            return;
        }
        int smallestIdx = findSmallest(x, start);
        swap(x, start, smallestIdx);
        sort(x, start + 1);
    }

    public static int findSmallest(String[] x, int start){
        int smallestIdx = start;
        for (int i = start; i < x.length; i++){
            int cmp = x[i].compareTo(x[smallestIdx]);
            if (cmp < 0) smallestIdx = i;
        }
        return smallestIdx;
    }

    public static void swap(String[] x, int a, int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }
}
