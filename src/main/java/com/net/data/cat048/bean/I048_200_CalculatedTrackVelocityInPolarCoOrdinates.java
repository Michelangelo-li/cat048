package com.net.data.cat048.bean;


import lombok.Data;

@Data
public class I048_200_CalculatedTrackVelocityInPolarCoOrdinates {
    private double CALCULATED_GroundSPEED;
    private double CALCULATED_HEADING;
    public static int length = 4;
    //(LSB) = (2^-14) NM/s = approx. 0.22 kt
    private double lsb1 = 0.22;
    //    (LSB) = 360°/ 216 = approx. 0.0055°
    private double lsb2 = 0.0055;

    public I048_200_CalculatedTrackVelocityInPolarCoOrdinates(int[] data, int index) {
        CALCULATED_GroundSPEED = (data[index] + data[index + 1]) * lsb1;
        CALCULATED_HEADING = (data[index + 2] + data[index + 3]) * lsb2;

    }

    @Override
    public String toString() {
        return CALCULATED_GroundSPEED + "," + CALCULATED_HEADING;
    }
}
