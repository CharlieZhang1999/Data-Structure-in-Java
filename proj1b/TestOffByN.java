import org.junit.Test;
import static org.junit.Assert.*;
public class TestOffByN {

    @Test
    public void testequalChars(){
        assertTrue(new OffByN(5).equalChars('a', 'f'));
        assertFalse(new OffByN(5).equalChars('a', 'F'));
        assertFalse(new OffByN(5).equalChars('a', 'a'));
    }

}
