package com.net.data.cat048.bean;

import lombok.Data;

import java.util.Arrays;


/**
 * 循环码奇偶性规则对照表
 * 循环码奇偶性   C1 C2 C4    十进制数
 * 偶数        0  0  1       0
 * 偶数        0  1  1       1
 * 偶数        0  1  0       2
 * 偶数        1  1  0       3
 * 偶数        1  0  0       4
 * <p>
 * 奇数        1  0  0       0
 * 奇数        1  1  0       1
 * 奇数        0  1  0       2
 * 奇数        0  1  1       3
 * 奇数        0  0  1       4
 */
@Data
public class I048_100_ModeCCodeAndCodeConfidenceIndicator {
    private int V;
    private int G;
    private String GrayCode;
    private String CyclicCode;
    private String ModeC;
    private String QualityPulse;
    private int cyclicCodeToInt;
    private String GrayBinary;
    private int GrayInt;
    private int maxHigh;
    private int minHigh;

    public static int length = 4;

    public I048_100_ModeCCodeAndCodeConfidenceIndicator(int[] data, int index) {
        int C1;
        int A1;
        int C2;
        int A2;
        int C4;
        int A4;
        int B1;
        int D1;
        int B2;
        int D2;
        int B4;
        int D4;
        C1 = (data[index] >> 3) & 0x01;
        A1 = (data[index] >> 2) & 0x01;
        C2 = (data[index] >> 1) & 0x01;
        A2 = (data[index]) & 0x01;
        C4 = (data[index + 1] >> 7) & 0x01;
        A4 = (data[index + 1] >> 6) & 0x01;
        B1 = (data[index + 1] >> 5) & 0x01;
        D1 = (data[index + 1] >> 4) & 0x01;
        B2 = (data[index + 1] >> 3) & 0x01;
        D2 = (data[index + 1] >> 2) & 0x01;
        B4 = (data[index + 1] >> 1) & 0x01;
        D4 = (data[index + 1]) & 0x01;

        GrayCode = D2 + "" + D4 + "" + A1 + "" + A2 + "" + A4 + "" + B1 + "" + B2 + "" + B4;
        CyclicCode = C1 + "" + C2 + "" + C4;
        // 循环码对应的十进制数
        cyclicCodeToInt = CyclicCodeToInt(GrayCode, CyclicCode);

        // 格雷码对应的二进制字符串
        GrayBinary = GrayCodeToBinaryCode(GrayCode);
        // 格雷码对应的二进制字符串转为十进制数值
        GrayInt = binToIct(GrayBinary);
        // 高度范围
        maxHigh = (GrayInt * 500 + cyclicCodeToInt * 100) - 1200 + 50;
        minHigh = (GrayInt * 500 + cyclicCodeToInt * 100) - 1200 - 50;


    }

    @Override
    public String toString() {
        return V + "," + G + ","+minHigh + "~" + maxHigh + "," + QualityPulse;
    }


    /**
     * 格雷码转二进制码原理
     * 保持格雷码最高位不变为二进制码的最高位。二进制最高位与格雷码次高位通过异或运算得到二进制次高位，依次类推得出其余二进制数。
     * Character.forDigit(int digit, int radix)将int转为char
     */
    private static String GrayCodeToBinaryCode(String GrayCode) {
        char[] grayCodeChars = GrayCode.toCharArray();
        char[] binaryCodeChars = new char[grayCodeChars.length];
        binaryCodeChars[0] = grayCodeChars[0];
        for (int i = 0; i < grayCodeChars.length - 1; i++) {
            binaryCodeChars[i + 1] = Character.forDigit((binaryCodeChars[i] ^ grayCodeChars[i + 1]), 2);
        }
        return new String(binaryCodeChars);
    }

    // 循环码对应的十进制数
    private static int CyclicCodeToInt(String GrayCode, String CyclicCode) {
        char[] chars = GrayCode.toCharArray();
        char obyte = chars[chars.length - 1];
        int cyclicCodeInt = 0;
        // 根据格雷码的最后一位的奇偶性来判断循环码对应的十进制数
        if (obyte == 0) {
            switch (CyclicCode) {
                case "001":
                    cyclicCodeInt = 0;
                    break;
                case "011":
                    cyclicCodeInt = 1;
                    break;
                case "010":
                    cyclicCodeInt = 2;
                    break;
                case "110":
                    cyclicCodeInt = 3;
                    break;
                case "100":
                    cyclicCodeInt = 4;
                    break;
            }
        } else {
            switch (CyclicCode) {
                case "100":
                    cyclicCodeInt = 0;
                    break;
                case "110":
                    cyclicCodeInt = 1;
                    break;
                case "010":
                    cyclicCodeInt = 2;
                    break;
                case "011":
                    cyclicCodeInt = 3;
                    break;
                case "001":
                    cyclicCodeInt = 4;
                    break;
            }
        }
        return cyclicCodeInt;
    }

    // 二进制字符串转换为十进制
    private static int binToIct(String bin) {
        int total = 0;
        char[] binCharArray = bin.toCharArray();
        for (int i = 0; i < binCharArray.length; i++) {
            total = total + binCharArray[i] - 48;
            if (i != binCharArray.length - 1) {
                total = total << 1;
            }
        }
        return total;
    }
}
