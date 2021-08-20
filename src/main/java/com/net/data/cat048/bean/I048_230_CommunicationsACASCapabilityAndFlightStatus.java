package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_230_CommunicationsACASCapabilityAndFlightStatus {
    private int COM;
    private int STAT;
    private int SI;
    private int MSSC;
    private int ARC;
    private int AIC;
    private int B1A;
    private int B1B;
    public static int length = 2;

    public I048_230_CommunicationsACASCapabilityAndFlightStatus(int[] data, int index) {
        COM = (data[index] >> 5) & 0x07;
        STAT = (data[index] >> 2) & 0x07;
        SI = (data[index] >> 1) & 0x01;
        MSSC = (data[index + 1] >> 7) & 0x01;
        ARC = (data[index + 1] >> 6) & 0x01;
        AIC = (data[index + 1] >> 5) & 0x01;
        B1A = (data[index + 1] >> 4) & 0x01;
        B1B = (data[index + 1]) & 0x0f;
    }

    @Override
    public String toString() {
        return COM + "," + STAT + "," + SI + "," + MSSC + "," + ARC + "," + AIC + "," + B1A + "," + B1B;
    }
}
