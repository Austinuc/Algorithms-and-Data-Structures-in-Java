package Arrays_Algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RangeCompactArrayTest {

    @Test

    public void basicTest() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", RangeCompactArray.rangeCompact(new ArrayList<Integer>(Arrays.asList(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20))));
    }

    @Test
    public void testNegativeRange() {
        assertEquals("-3--1,2,10,15,16,18-20", RangeCompactArray.rangeCompact(new ArrayList<Integer>(Arrays.asList(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20))));
    }
}