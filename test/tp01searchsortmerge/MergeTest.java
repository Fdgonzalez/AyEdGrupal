package tp01searchsortmerge;


import java.util.Arrays;
import static tp01searchsortmerge.Merge.merge;
import static org.junit.Assert.*;


public class MergeTest {
    @org.junit.Test
    public void mergeTest() {
        Integer[] arrayA = {1, 2, 3};
        Integer[] arrayB = {2, 4};
        Integer[] resultArray = {1, 2, 2, 3, 4};
        assertEquals(Arrays.toString(resultArray), Arrays.toString(merge(arrayA, arrayB)));
    }
}
