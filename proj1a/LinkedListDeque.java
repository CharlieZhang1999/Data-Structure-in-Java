public class LinkedListDeque<Heels> {
    public class StuffNode {
        public Heels first;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(Heels x, StuffNode n){
            first = x;
            next = n;
        }

        public StuffNode goRecursive(int x){
            if(x==0){
                return this;
            }
            return this.goRecursive(x-1);
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
    public void addFirst(Heels x){
        StuffNode first  =  new StuffNode(x, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        first.prev = sentinel;
        size = size + 1;
    }

    public void addLast(Heels x){
        StuffNode last = new StuffNode(x, sentinel);
        last.prev = sentinel.prev;
        sentinel.prev.next = last;
        sentinel.prev = last;
        size = size + 1;
    }
    public int size(){
        return size;
    }

    public StuffNode removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        StuffNode first = sentinel.next;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size = size - 1;
        return first;
    }

    public StuffNode removeLast(){
        if(this.isEmpty()){
            return null;
        }
        StuffNode last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size = size - 1;
        return last;
    }

    public StuffNode get(int index){
         if(this.size==0 || index > this.size()){
             return null;
         }

        StuffNode ret = sentinel.next;
         while(index > 0){
             ret = ret.next;
             index--;
         }
         return ret;
    }
    public StuffNode getRecursive(int index){
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
