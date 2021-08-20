package com.net.data.cat048.I048_130;


import lombok.Data;

@Data
public class NumberOfReceivedRepliesForMSSR {
    // LSB= 1
    private int SSR;
    public static int length = 1;

    public NumberOfReceivedRepliesForMSSR(int[] data, int index) {
        SSR = data[index];
    }

    @Override
    public String toString() {
        return SSR+"";
    }
}
