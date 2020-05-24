public class LinkedListDeque<T> {
    private class StuffNode {
        public T first;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T x, StuffNode n){
            first = x;
            next = n;
        }

        public T goRecursive(int x){
            if(x==0){
                return this.first;
            }
            return this.next.goRecursive(x-1);
        }
    }
    private StuffNode sentinel;
    private int size;
    private StuffNode front;

    public LinkedListDeque(){
        sentinel = new StuffNode(null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    /*public void LinkedListDeque(int x){
        IntNode first = new IntNode(x, null);
        sentinel = new IntNode(63, first);
        sentinel.prev =  first;
        first.prev = sentinel;
        first.next = sentinel;
        size = 1;

    }*/
    public void addFirst(T x){
        StuffNode first  =  new StuffNode(x, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        first.prev = sentinel;
        size = size + 1;
    }

    public void addLast(T x){
        StuffNode last = new StuffNode(x, sentinel);
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        sentinel.prev = last;
        size = size + 1;
    }
    public int size(){
        return size;
    }

    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        StuffNode first = sentinel.next;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size = size - 1;
        return first.first;
    }

    public T removeLast(){
        if(this.isEmpty()){
            return null;
        }
        StuffNode last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size = size - 1;
        return last.first;
    }

    public T get(int index){
         if(this.size==0 || index > this.size()){
             return null;
         }

        StuffNode ret = sentinel.next;
         while(index > 0){
             ret = ret.next;
             index--;
         }
         return ret.first;
    }
    public T getRecursive(int index){
         if(this.isEmpty()){
             return null;
         }
         return sentinel.next.goRecursive(index);
    }

    public boolean isEmpty(){
        if(this.size()==0){
            return true;
        }
        else return false;
    }
    public void printDeque(){
        if(this.isEmpty()){
            return;
        }
        StuffNode cur = sentinel.next;
        while(cur!=sentinel){
            System.out.println(cur.first);
            cur = cur.next;
        }
    }

}
