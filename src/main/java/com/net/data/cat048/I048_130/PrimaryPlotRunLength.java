package com.net.data.cat048.I048_130;

import lombok.Data;


@Data
public class PrimaryPlotRunLength {
    // LSB= 360/2 13 dg (0.044 dg)
    private double PRL;
    public static int length = 1;

    public PrimaryPlotRunLength(int[] data, int index) {
        PRL = data[index] * 0.044;
    }

    @Override
    public String toString() {
        return PRL + "";
    }
}