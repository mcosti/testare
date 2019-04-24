package pachet2;
import pachet1.Permutation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermutationTest {
    String emptyString = "";
    String easyString = "abcdef";
    String lorem99 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ";
    String lorem100 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m";
    String lorem101 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean mm";

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownEmptyString() {
        Permutation tester = new Permutation();
        tester.permute(emptyString, 1, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownLongString() {
        Permutation tester = new Permutation();
        tester.permute(lorem101, 1, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownTimesTooLow() {
        Permutation tester = new Permutation();
        tester.permute(easyString, 0, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownTimesTooHigh() {
        Permutation tester = new Permutation();
        tester.permute(easyString, 101, true);
    }

    @Test
    public void testPermuteOne() {
        Permutation tester = new Permutation();
        assertEquals("bcdefa", tester.permute(easyString, 1, false));
    }

    @Test
    public void testPermuteTwo() {
        Permutation tester = new Permutation();
        assertEquals("efabcd", tester.permute(easyString, 2, true));
    }

    @Test
    public void testLorem99Times() {
        Permutation tester = new Permutation();
        assertEquals("mLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ", tester.permute(lorem100, 99, false));
    }

    @Test
    public void testLoremRight() {
        Permutation tester = new Permutation();
        assertEquals(lorem100, tester.permute(lorem100, lorem100.length(), true));
    }

    @Test
    public void testLoremLeft() {
        Permutation tester = new Permutation();
        assertEquals(lorem100, tester.permute(lorem100, lorem100.length(), false));
    }

}
