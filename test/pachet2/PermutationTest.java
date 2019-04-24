package pachet2;
import pachet1.Permutation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermutationTest {
    String emptyString = "";
    String oneCharString = "a";
    String easyString = "abcdef";
    String lorem99 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ";
    String lorem100 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m";
    String lorem101 = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean mm";

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownEmptyString() {
        Permutation tester = new Permutation();
        tester.permute(emptyString, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownLongString() {
        Permutation tester = new Permutation();
        tester.permute(lorem101, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownTimesTooLow() {
        Permutation tester = new Permutation();
        tester.permute(easyString, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownTimesTooHigh() {
        Permutation tester = new Permutation();
        tester.permute(easyString, 101, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownRightInvalid1() {
        Permutation tester = new Permutation();
        tester.permute(easyString, 100, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionIsThrownRightInvalid2() {
        Permutation tester = new Permutation();
        tester.permute(easyString, 100, 2);
    }

    @Test
    public void testOneChar(){
        Permutation tester = new Permutation();
        assertEquals("a", tester.permute(oneCharString, 88, 1));
    }

    @Test
    public void testPermuteOne() {
        Permutation tester = new Permutation();
        assertEquals("bcdefa", tester.permute(easyString, 1, 0));
    }

    @Test
    public void testPermuteTwo() {
        Permutation tester = new Permutation();
        assertEquals("efabcd", tester.permute(easyString, 2, 1));
    }

    @Test
    public void testLorem99Times() {
        Permutation tester = new Permutation();
        assertEquals("mLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean ", tester.permute(lorem100, 99, 0));
    }

    @Test
    public void testLoremRight() {
        Permutation tester = new Permutation();
        assertEquals(lorem100, tester.permute(lorem100, lorem100.length(), 1));
    }

    @Test
    public void testLoremLeft() {
        Permutation tester = new Permutation();
        assertEquals(lorem100, tester.permute(lorem100, lorem100.length(), 0));
    }

}
