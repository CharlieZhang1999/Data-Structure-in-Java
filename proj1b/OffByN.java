public class OffByN implements CharacterComparator {
    private int n;

    public OffByN(int i) {
        n = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if(diff == n || diff == -n){
            return true;
        }
        return false;
    }
}
