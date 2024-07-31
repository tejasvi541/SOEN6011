package org.soen6011;

import static org.junit.Assert.*;

import org.soen6011.backend.StandardDeviation;

public class StandardDeviationTest {


    @org.junit.Test
    public void calculateMean() {
        double[] arr = {1,2,3,4,5};
        assertEquals(3.0, StandardDeviation.calculateMean(arr), 0.0001);
    }

    @org.junit.Test
    public void calculateVariance() {
        double[] arr = {1,2,3,4,5};
        assertEquals(2, StandardDeviation.calculateVariance(arr, 3.0), 0.00001);
    }

    @org.junit.Test
    public void findSqrt() {
        assertEquals(3.0, StandardDeviation.findSqrt(9), 0.0001);
    }

    @org.junit.Test
    public void calculateStandardDeviation() {
        double[] arr = {1,2,3,4,5};
        assertEquals(1.4811388, StandardDeviation.calculateStandardDeviation(arr), 0.1);
    }
}