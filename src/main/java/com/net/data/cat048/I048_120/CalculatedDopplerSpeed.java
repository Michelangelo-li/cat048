package com.net.data.cat048.I048_120;


import lombok.Data;

@Data
public class CalculatedDopplerSpeed {
    private int D;
    //LSB= 1 m/sec
    private int CAL;
    public static int length = 2;

    public CalculatedDopplerSpeed(int[] data, int index) {
        System.out.println("data[index]" + data[index]);
        D = data[index] >> 7;
        CAL = (data[index] & 0x03) << 8 | data[index + 1];
    }

    @Override
    public String toString() {
        return D + "," + "CAL:" + CAL;
    }
}
