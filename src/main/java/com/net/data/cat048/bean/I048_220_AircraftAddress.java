package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_220_AircraftAddress {

    private int aircraftAddress;
    public static int length = 3;

    public I048_220_AircraftAddress(int[] data, int index) {
        aircraftAddress = data[index] << 16 | data[index + 1] << 8 | data[index + 2];
        System.out.println("=======");
    }

    @Override
    public String toString() {
        return aircraftAddress + "";
    }
}
