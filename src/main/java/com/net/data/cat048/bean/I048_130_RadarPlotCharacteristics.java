package com.net.data.cat048.bean;


import com.alibaba.fastjson.annotation.JSONField;
import com.net.data.cat048.I048_130.*;
import lombok.Data;

@Data
public class I048_130_RadarPlotCharacteristics {
    @JSONField(serialize = false)
    private boolean[] existedItems = new boolean[8];

    private SSRPlotRunLength ssrPlotRunLength = null;
    private NumberOfReceivedRepliesForMSSR numberOfReceivedRepliesForMSSR = null;
    private AmplitudeOfMSSRReply amplitudeOfMSSRReply = null;
    private PrimaryPlotRunLength primaryPlotRunLength = null;
    private AmplitudeOfPrimaryPlot amplitudeOfPrimaryPlot = null;
    private DifferenceInRangeBetweenPSRAndSSRPlot differenceInRangeBetweenPSRAndSSRPlot = null;
    private DifferenceInAzimuthBetweenPSRAndSSRPlot differenceInAzimuthBetweenPSRAndSSRPlot = null;


    public static int length;

    public I048_130_RadarPlotCharacteristics(int[] data, int index) {


        int currentIndex = index;
        int oByte = 0;
        int itemIndex = 8;

        do {
            // adr
            oByte = data[currentIndex];

            for (int i = 7; i >= 1; i--) { //7
                itemIndex -= 1; //31
                // 1 为 true
                existedItems[itemIndex] = ((oByte >> i) & 0x01) == 0x01;
            }
            itemIndex -= 1;
            currentIndex += 1;

        } while ((oByte & 0x01) == 0x01);
//        System.out.println("existedItems:");
//        for (boolean b:existedItems){
//            System.out.print(b+" ");
//        }
        if (existedItems[7]) {
            ssrPlotRunLength = new SSRPlotRunLength(data, currentIndex);
            currentIndex += SSRPlotRunLength.length;
        }
        if (existedItems[6]) {
            numberOfReceivedRepliesForMSSR = new NumberOfReceivedRepliesForMSSR(data, currentIndex);
            currentIndex += NumberOfReceivedRepliesForMSSR.length;
        }
        if (existedItems[5]) {
            amplitudeOfMSSRReply = new AmplitudeOfMSSRReply(data, currentIndex);
            currentIndex += AmplitudeOfMSSRReply.length;
        }
        if (existedItems[4]) {
            primaryPlotRunLength = new PrimaryPlotRunLength(data, currentIndex);
            currentIndex += PrimaryPlotRunLength.length;
        }
        if (existedItems[3]) {
            amplitudeOfPrimaryPlot = new AmplitudeOfPrimaryPlot(data, currentIndex);
            currentIndex += AmplitudeOfPrimaryPlot.length;
        }
        if (existedItems[2]) {
            differenceInRangeBetweenPSRAndSSRPlot = new DifferenceInRangeBetweenPSRAndSSRPlot(data, currentIndex);
            currentIndex += DifferenceInRangeBetweenPSRAndSSRPlot.length;
        }
        if (existedItems[1]) {
            differenceInAzimuthBetweenPSRAndSSRPlot = new DifferenceInAzimuthBetweenPSRAndSSRPlot(data, currentIndex);
            currentIndex += DifferenceInAzimuthBetweenPSRAndSSRPlot.length;
        }
        length = currentIndex - index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(1024);

        return stringBuilder.append(ssrPlotRunLength)
                .append(",").append(numberOfReceivedRepliesForMSSR)
                .append(",").append(amplitudeOfMSSRReply)
                .append(",").append(primaryPlotRunLength)
                .append(",").append(amplitudeOfPrimaryPlot)
                .append(",").append(differenceInRangeBetweenPSRAndSSRPlot)
                .append(",").append(differenceInAzimuthBetweenPSRAndSSRPlot)
                .toString();
    }
}
