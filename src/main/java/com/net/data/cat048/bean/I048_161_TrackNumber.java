package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_161_TrackNumber {
    private int Track_Number;
    public static int length = 2;

    public I048_161_TrackNumber(int[] data, int index) {
        Track_Number = (data[index] & 0x0f) << 8 | data[index + 1];
    }

    @Override
    public String toString() {
        return Track_Number + "";
    }
}
