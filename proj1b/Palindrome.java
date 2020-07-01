public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> arr = new ArrayDeque<Character>();
        for(int i = word.length() - 1; i >= 0 ; i--){
            arr.addFirst(word.charAt(i));
        }
        return arr;
    }

    public boolean isPalindrome(String word){
        Deque<Character> arr = this.wordToDeque(word);
        while (arr.size() > 1){
            char first = arr.removeFirst();
            char last = arr.removeLast();
            if(first != last){
                return false;
            }
        }
        return true;
    }

    //this is the function that check if the word is a OffByOne palindrome. For example, "flake" is an off-by-one palindrome.
    public boolean isPalindrome(String word, CharacterComparator cc){
        for(int i = 0; i < word.length() / 2; i++){
            if(!cc.equalChars(word.charAt(i), word.charAt(word.length() - 1 - i))){
                return false;
            }
        }
        return true;
    }
}
