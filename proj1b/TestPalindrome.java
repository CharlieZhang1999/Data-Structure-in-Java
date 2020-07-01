import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("bb"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("terret"));
        assertFalse(palindrome.isPalindrome("Racecar"));
        assertFalse(palindrome.isPalindrome("aaab"));
        assertFalse(palindrome.isPalindrome("cat"));

    }

    @Test
    public void testisPalindrome_2() {
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("a", new OffByOne()));
        assertTrue(palindrome.isPalindrome("ab", new OffByOne()));
        assertTrue(palindrome.isPalindrome("flake", new OffByOne()));
        assertFalse(palindrome.isPalindrome("aaaab", new OffByOne()));
        assertFalse(palindrome.isPalindrome("racecar", new OffByOne()));
    }

    @Test
    public void testisPalindrome_3() {
        assertTrue(palindrome.isPalindrome("", new OffByN(5)));
        assertTrue(palindrome.isPalindrome("a", new OffByN(5)));
        assertTrue(palindrome.isPalindrome("af", new OffByN(5)));
        assertTrue(palindrome.isPalindrome("jlape", new OffByN(5)));
        assertFalse(palindrome.isPalindrome("aaaab", new OffByN(5)));
        assertFalse(palindrome.isPalindrome("racecar", new OffByN(5)));
    }
}
