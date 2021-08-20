package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_140_TimeOfDay {

    //(LSB) = 2 -7 seconds = 1/128 seconds
    private double TimeOfDay;
    public static int length = 3;
    private static double ratio = 128.0;

    public I048_140_TimeOfDay(int[] data, int index) {
        TimeOfDay = (data[index] << 16 | data[index + 1] << 8 | data[index + 2]) /ratio;
    }

    @Override
    public String toString() {
        return TimeOfDay + "";
    }
}
