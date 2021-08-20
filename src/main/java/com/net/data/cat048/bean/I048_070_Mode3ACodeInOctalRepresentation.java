package com.net.data.cat048.bean;

import lombok.Data;

@Data
public class I048_070_Mode3ACodeInOctalRepresentation {
    private int V;
    private int G;
    private int L;
    private String Mode3A_COde;

    public static int length = 2;

    // bit-13 Spare bit set to 0
    public I048_070_Mode3ACodeInOctalRepresentation(int[] data, int index) {
        int A;
        int B;
        int C;
        int D;
        // 111
        V = (data[index] >> 7) & 0x01;
        G = (data[index] >> 6) & 0x01;
        L = (data[index] >> 5) & 0x01;

        A = (data[index] >> 1) & 0x07;

        B = ((data[index] & 0x01) << 2) | ((data[index + 1] & 0xc0) >> 6);

        C = ((data[index + 1]) >> 3 & 0x07);

        D = (data[index + 1]) & 0x07;

        Mode3A_COde = A + "" + B + "" + C + "" + D;
    }

    @Override
    public String toString() {
        return V + "," + G + "," + L + "," + Mode3A_COde;
    }
}
