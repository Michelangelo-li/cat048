package com.net.data.cat048.decoder;

import java.util.Base64;

/**
 * https://blog.csdn.net/xuedengyong/article/details/81386225
 * https://stackoverflow.com/questions/11380062/what-does-value-0xff-do-in-java
 * <p>
 * 进行&运算，只会保留
 * <p>
 * 低八位，也就是byte中原来在计算机中存储的值
 */
public class CommonUtil {

    /**
     * byte java 中一个字节 8位 即 -2^7—2^7-1  范围是 -128——127 (*对这个有疑问吗？在2 中解答)
     * <p>
     * 计算机中负数的存储的值是它的补码
     * <p>
     * 补码计算方法  负数取值是它的绝对值，的二进制数，取反，加1，那么对于          -128——-1的存储 就知道了吧
     * <p>
     * bytes[i] & 0xFF 原理详解
     * <p>
     * 当byte要转化为int的时候，高的24位必然会补1，这样，其二进制补码其实已经不一致了，
     * 0xff
     * &0xff可以将高的24位置为0，低8位保持原样。这样做的目的就是为了保证二进制数据的一致性。
     *
     * @param b64String
     * @return
     */
    public static int[] base64ToIntArray(String b64String) {

        // 对byte[]编码=》String   对string解码=》bytes
        byte[] bytes = Base64.getDecoder().decode(b64String);

        int[] bytesInt = new int[bytes.length];
        int i = 0;
        while (i < bytes.length) {
            bytesInt[i] = bytes[i] & 0xFF; //11111111
            i += 1;
        }

        return bytesInt;
    }

    public static int twosComplement(int integer, int bitCount) {
        if (bitCount > 32 || bitCount <= 0) {
            try {
                throw new Exception("错误的可计算bit位数。");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (((integer >> (bitCount - 1)) & 0x01) == 0x01) {
            return integer | ~((1 << bitCount) - 1);
        } else {
            return integer & ((1 << bitCount) - 1);
        }
    }

    public static String bytesToCallsign(int[] bytes) {
        int char1234 = (bytes[0] << 16) | (bytes[1] << 8) | bytes[2];
        int char5678 = (bytes[3] << 16) | (bytes[4] << 8) | bytes[5];

        char[] charArray = new char[]{
                bit6ToChar((char1234 >> 18) & 0x3F),
                bit6ToChar((char1234 >> 12) & 0x3F),
                bit6ToChar((char1234 >> 6) & 0x3F),
                bit6ToChar(char1234 & 0x3F),
                bit6ToChar((char5678 >> 18) & 0x3F),
                bit6ToChar((char5678 >> 12) & 0x3F),
                bit6ToChar((char5678 >> 6) & 0x3F),
                bit6ToChar(char5678 & 0x3F)
        };

        return new String(charArray).trim();
    }


    private static char bit6ToChar(int bit6) {
        if (bit6 == 32) {
            return ' ';
        } else if (bit6 >= 1 && bit6 <= 26) {
            return (char) (64 + bit6);
        } else if (bit6 >= 48 && bit6 <= 57) {
            return (char) bit6;
        } else {
            return '*';
        }
    }

    // 十六进制字符串转化成int数组
    public static int[] hexString2Ints(String hex) {

        if ((hex == null) || (hex.equals(""))) {
            return null;
        } else if (hex.length() % 2 != 0) {
            return null;
        } else {
            hex = hex.toUpperCase();
            int len = hex.length() / 2;
            byte[] bytes = new byte[len];
            char[] hc = hex.toCharArray();
            for (int i = 0; i < len; i++) {
                int p = 2 * i;
                bytes[i] = (byte) (charToByte(hc[p]) << 4 | charToByte(hc[p + 1]));
            }

            int[] bytesInt = new int[bytes.length];
            int i = 0;
            while (i < bytes.length) {
                bytesInt[i] = bytes[i] & 0xFF; //11111111
                i += 1;
            }
            return bytesInt;
        }
    }

    //    字符转换为字节
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
