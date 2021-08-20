package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_110_HeightMeasuredByA3DRadar {
    private int ThreeD_Height;
    public static int length = 2;
    private static int ratio = 25;

    public I048_110_HeightMeasuredByA3DRadar(int[] data,int index) {
        // 0110
        // 0011
        // 0111
        System.out.println((data[index] & 0x3f) << 8 | data[index + 1]);
        ThreeD_Height = ((data[index] & 0x3f) << 8 | data[index + 1]) * ratio;

    }
    // TODO: 2021/8/17
    @Override
    public String toString() {
        return ThreeD_Height+"";
    }
}

