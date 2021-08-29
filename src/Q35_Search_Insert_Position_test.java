import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q35_Search_Insert_Position_test {
    @Test
    public void Search_Insert_Position_test1 () {
        int[] a1 = new int[] {1,3,5,6};
        int a = 5;
        int res1 = Q35_Search_Insert_Position.searchInsert(a1,a);
        int expected = 2;
        assertEquals(expected, res1);
    }
    @Test
    public void Search_Insert_Position_test2 () {
        int[] b1 = new int[] {1,3,5,6};
        int b = 2;
        int res2 = Q35_Search_Insert_Position.searchInsert(b1,b);
        int expected = 1;
        assertEquals(expected, res2);
    }
}
