package com.net.data.cat048.I048_130;


import lombok.Data;

@Data
public class AmplitudeOfMSSRReply {
    // LSB= 1 dBm
    private int SAM;
    public static int length = 1;

    public AmplitudeOfMSSRReply(int[] data, int index) {
        SAM = data[index];
    }

    @Override
    public String toString() {
        return SAM + "";
    }
}
