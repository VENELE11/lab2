import org.junit.Test;
import static org.junit.Assert.*;

public class L2022112008_5_test {

    /**
     * Test case design principles:
     * 1. Equivalence partitioning: Divide the input array and target value into different equivalence classes to ensure representative test cases for each class.
     * 2. Boundary value analysis: Test boundary cases such as the minimum value, maximum value, and empty array.
     * 3. Special case testing: Test arrays with duplicate elements, arrays where all elements are the same, etc.
     */

    @Test
    public void testNumSubseq() {
        Solution5 solution = new Solution5();

        // Equivalence partitioning tests
        assertEquals(4, solution.numSubseq(new int[]{3, 5, 6, 7}, 9));
        assertEquals(6, solution.numSubseq(new int[]{3, 3, 6, 8}, 10));
        assertEquals(61, solution.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));

        // Boundary value analysis tests
        assertEquals(0, solution.numSubseq(new int[]{}, 5)); // Empty array
        assertEquals(0, solution.numSubseq(new int[]{10}, 5)); // Single element greater than target

        // Special case tests
        assertEquals(15, solution.numSubseq(new int[]{1, 1, 1, 1}, 2)); // All elements the same
        assertEquals(0, solution.numSubseq(new int[]{10, 20, 30}, 5)); // All elements greater than target
    }
}