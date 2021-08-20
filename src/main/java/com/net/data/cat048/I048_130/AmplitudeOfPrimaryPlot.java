package com.net.data.cat048.I048_130;

import lombok.Data;


@Data
public class AmplitudeOfPrimaryPlot {
    // LSB= 1 dBm
    private int PAM;
    public static int length = 1;

    public AmplitudeOfPrimaryPlot(int[] data, int index) {
        PAM = data[index];
    }

    @Override
    public String toString() {
        return PAM + "";
    }
}