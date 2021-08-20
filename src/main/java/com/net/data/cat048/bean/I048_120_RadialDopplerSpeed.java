package com.net.data.cat048.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.net.data.cat048.I048_120.CalculatedDopplerSpeed;
import com.net.data.cat048.I048_120.RawDopplerSpeed;
import lombok.Data;

@Data
public class I048_120_RadialDopplerSpeed {
    @JSONField(serialize = false)
    private boolean[] existedItems = new boolean[8];

    private CalculatedDopplerSpeed calculatedDopplerSpeed = null;
    private RawDopplerSpeed rawDopplerSpeed = null;
    public static int length;


    public I048_120_RadialDopplerSpeed(int[] data, int index) {

        int currentIndex = index;
        int oByte = 0;
        int itemIndex = 8;

//        do {
//            // adr
//            oByte = data[currentIndex];
//
//            for (int i = 7; i >= 1; i--) { //7
//                itemIndex -= 1; //7
//                // 1 为 true
//                existedItems[itemIndex] = ((oByte >> i) & 0x01) == 0x01;
//            }
//            itemIndex -= 1;
//            currentIndex += 1;
//
//        } while (false);


        oByte = data[currentIndex];
        for (int i = 7; i >= 1; i--) { //7
            itemIndex -= 1; //7
            // 1 为 true
            existedItems[itemIndex] = ((oByte >> i) & 0x01) == 0x01;
        }
        currentIndex += 1;

        if (existedItems[7]) {
            calculatedDopplerSpeed = new CalculatedDopplerSpeed(data, currentIndex);
            currentIndex += CalculatedDopplerSpeed.length;
        }
        if (existedItems[6]) {
            rawDopplerSpeed = new RawDopplerSpeed(data, currentIndex);
            currentIndex += RawDopplerSpeed.length;
        }
        length = currentIndex - index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(1024);

        return stringBuilder.append(calculatedDopplerSpeed)
                .append(",").append(rawDopplerSpeed)
                .toString();
    }
}
