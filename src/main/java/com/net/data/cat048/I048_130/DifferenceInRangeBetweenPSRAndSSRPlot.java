package com.net.data.cat048.I048_130;


import lombok.Data;

@Data
public class DifferenceInRangeBetweenPSRAndSSRPlot {
    // LSB= 1/256 NM
    private double RPD;
    public static int length = 1;
    private static double lsb = 256.0;

    public DifferenceInRangeBetweenPSRAndSSRPlot(int[] data, int index) {
        RPD = data[index] / lsb;
    }

    @Override
    public String toString() {
        return RPD + "";
    }
}