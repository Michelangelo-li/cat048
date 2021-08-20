package com.net.data.cat048.I048_120;


import lombok.Data;

@Data
public class RawDopplerSpeed {
    private int REP;
    //    LSB= 1 m/sec
    private int DOP;
    //    LSB= 1 m/sec
    private int AMB;
    //    LSB= 1 Mhz
    private int FRQ;

    public static int length = 7;

    public RawDopplerSpeed(int[] data, int index) {
        REP = data[index];
        DOP = data[index + 1] << 8 | data[index + 2];
        AMB = data[index + 3] << 8 | data[index + 4];
        FRQ = data[index + 5] << 8 | data[index + 6];
    }

    @Override
    public String toString() {
        return REP + "," + DOP + "," + AMB + "," + FRQ;
    }
}
