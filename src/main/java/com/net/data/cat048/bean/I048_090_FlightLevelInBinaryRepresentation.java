package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_090_FlightLevelInBinaryRepresentation {
    private int V;
    private int G;
    private double Flight_Level;
    private double ratio = 0.25;
    public static int length = 2;

    public I048_090_FlightLevelInBinaryRepresentation(int[] data, int index) {
        V = (data[index] >> 7) & 0x01;
        G = (data[index] >> 6) & 0x01;
        //1101 0100 0101 0111 20+87

        Flight_Level = ((data[index] & 0x3f) << 8 | data[index + 1]) * ratio;
    }

    @Override
    public String toString() {
        return V + "," + G + "," + Flight_Level;
    }
}
