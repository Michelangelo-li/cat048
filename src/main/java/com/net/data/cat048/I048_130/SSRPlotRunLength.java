package com.net.data.cat048.I048_130;


import lombok.Data;

@Data
public class SSRPlotRunLength {
    //LSB=360/2 13 dg (0.044 dg)
    private double SRL;
    public static int length = 1;

    public SSRPlotRunLength(int[] data, int index) {
        SRL = data[index] * 0.044;
    }

    @Override
    public String toString() {
        return SRL+"";
    }
}
