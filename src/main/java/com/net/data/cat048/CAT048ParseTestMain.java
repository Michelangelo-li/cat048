package com.net.data.cat048;

import com.alibaba.fastjson.JSON;
import com.net.data.cat048.decoder.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CAT048ParseTestMain {

    public static String parseStr(String kafkaMsgStr) {
        Data data = new Data();
        InnerData innerData = new InnerData();
        innerData.setValue(kafkaMsgStr);
        data.setData(innerData);

        CAT048KafkaMsgNew cat048KafkaMsg = new CAT048KafkaMsgNew(data);

        String value = cat048KafkaMsg.getData().getData().getValue();


        //把十六进制的字符串转化为int数组
        int[] ints = CommonUtil.hexString2Ints(value);
//
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i]+" ");
//        }
        System.out.println();
        try {
            CAT048Data cat048Data = new CAT048Data(ints, 0, cat048KafkaMsg.getDataLength());
            System.out.println(JSON.toJSONString(cat048Data));
            System.out.println(cat048Data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // byte数组转换为十六进制的
    public static String bytes2hex02(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1)// 每个字节8为，转为16进制标志，2个16进制位
            {
                tmp = "0" + tmp;
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static String string2HexString(String s) throws Exception {
        String r = bytes2HexString(string2Bytes(s));
        return r;
    }

    public static String bytes2HexString(byte[] b) {
        String r = "";

        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            r += hex.toUpperCase();
        }

        return r;
    }

    public static byte[] string2Bytes(String s) {
        byte[] r = s.getBytes();
        return r;
    }

    public static void main(String[] args) throws Exception {
//        String path = new CAT034ParseTestMain().getClass().getClassLoader().getResource("MEX22021011453.ast").getPath();
//        DataInputStream dis = new DataInputStream(new FileInputStream(path));

//         读取二进制文件存入byte[]数组
//        byte[] inputBytes = new byte[100000000];
//        int temp;
//        int i = 0;
//        while ((temp = dis.read()) != -1) {
//            inputBytes[i] = (byte) temp;
//            i++;
//        }
//         把byte[] 数组转化为 String
//        String s = bytes2hex02(inputBytes);
//        System.out.println(s.substring(0, 50));
        //220010f61665022a3420e08840408000
//        f6 246 1111 0110
//        String s1 = "220010f61665022a3420e08840408000";
//                   220010f61665022a3420e08840408000
//30003cffe10216652a3407a88111d3f40a3204b5e02004c07807d810b231c39ce003bac800316c000040fffb37286004ed50dc8a5931bff4006020f5



//        300016fe16652a340848497ed469032b018ce04606bc
//
//        String s2 = "220010f61665022a3420e0884040800030003cffe10216652a";
//        String s = "300016fe16652a340848497ed469032b018ce04606bc";
//        String s = "30003cffe10216652a3ba0a88ba3a0130888057ce01603bf78158a10b231c37e2003b0100030a4018040fe13ff4cffecf250a1ba2f337ff7fd6020";
//        String s = "30003cffe10216652a3b86a86eb893640644041a";
        // 250 出问题
        String s1 = "30003cffe10216652a34aba8347c25e201c202fae01203c678119d0c54f6cf6ca0038f700030a4000040fff709323ffcc750bd2a59283dcfb66020f5";
        String s = "300016fe16652a34f5486b5d4b0005490294e04a06c2";
        System.out.println(parseStr(s));
    }
}
