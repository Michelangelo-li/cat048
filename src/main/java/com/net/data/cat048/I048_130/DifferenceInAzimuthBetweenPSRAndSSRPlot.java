package com.net.data.cat048.I048_130;

import lombok.Data;

@Data
public class DifferenceInAzimuthBetweenPSRAndSSRPlot {
    // LSB= 360/2^14 dg
    private double APD;
    public static int length = 1;
    private static double lsb = (360 / Math.pow(2, 14));

    public DifferenceInAzimuthBetweenPSRAndSSRPlot(int[] data, int index) {
        APD = data[index] * lsb;
    }

    @Override
    public String toString() {
        return APD + "";
    }
}