package com.net.data.cat048.decoder;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CAT048Data {

    public static final int CAT048_ID = 48;

//    @Getter
//    @Setter
//    private long receiveTime;

    @Getter
    @Setter
    private CAT048Track[] trackArray;

    @Getter
    @Setter
    @JSONField(serialize = false)
    private List<CAT048Track> trackList;


    public CAT048Data(int[] data, int startIndex, int dataLength) throws Exception {
        int currentIndex = startIndex;

        if (data[currentIndex] != CAT048_ID) {
            throw new Exception("不是ASTERIX-CAT048格式数据");
        }

        // UAP中的lenth 为int数组的第二位和第三位的和
//        System.out.println("length"+((data[currentIndex + 1] << 8) + data[currentIndex + 2]));
        int length = (data[currentIndex + 1] << 8) + data[currentIndex + 2];
//        System.out.println("lenth:"+length);
//        if (dataLength != length || data.length - startIndex < dataLength) {
//            throw new Exception("ASTERIX-CAT062数据长度错误");
//        }

        currentIndex += 3;
        trackList = new ArrayList();

        //startIndex=0
        //3
        //
        while (currentIndex - startIndex < length) {

            // int[] data currentIndex = 3
            CAT048Track track = new CAT048Track(data, currentIndex);

            trackList.add(track);
            currentIndex += CAT048Track.length;
        }


        if (currentIndex - startIndex != length) {

            throw new Exception("ASTERIX CAT048数据解析错误。");
        }
        this.trackArray = trackList.toArray(new CAT048Track[]{});

//        this.receiveTime = receiveTime;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(4096);
//        stringBuilder.append(receiveTime);

        for (CAT048Track track : trackList) {
//            stringBuilder.append("#").append(track.toString());
            stringBuilder.append(track.toString());
        }
        return stringBuilder.toString();
    }

}
