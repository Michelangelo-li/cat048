package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_210_TrackQuality {
    private double SigmaX;
    private double SigmaY;
    private double SigmaV;
    private double SigmaH;
    //(LSB) = 1/128 NM
    private static final double lsb1 = 128.0;
    //(LSB) = (2-14) NM/s = 0.22 Kt
    private static final double lsb2 = 0.22;
    //(LSB) = 360/(212) degrees = 0.08789 degrees
    private static final double lsb3 = 0.08789;
    public static int length = 4;

    public I048_210_TrackQuality(int[] data, int index) {
        SigmaX = (data[index]) / lsb1;
        SigmaY = (data[index + 1]) / lsb1;
        SigmaV = (data[index + 2]) * lsb2;
        SigmaH = (data[index + 3]) * lsb3;
    }

    @Override
    public String toString() {
        return SigmaX + "," + SigmaY + "," + SigmaV + "," + SigmaH;
    }
}
