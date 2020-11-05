package com.tooonly.util.security;


import java.util.concurrent.atomic.AtomicLong;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
    private static BASE64Encoder[] encoders = new BASE64Encoder[]{new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder(), new BASE64Encoder()};
    private static BASE64Decoder[] decoders = new BASE64Decoder[]{new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder(), new BASE64Decoder()};
    private static AtomicLong alEncoderIndex = new AtomicLong(0L);
    private static AtomicLong alDecoderIndex = new AtomicLong(0L);

    public Base64() {
    }

    public static String encode(byte[] bysData) {
        int nIndex = (int)(alEncoderIndex.incrementAndGet() % (long)encoders.length);
        String strEncoded = null;
        synchronized(encoders[nIndex]) {
            strEncoded = encoders[nIndex].encode(bysData);
        }

        strEncoded = strEncoded.replaceAll("\r\n", "");
        return strEncoded;
    }

    public static byte[] decode(String strData) {
        int nIndex = (int)(alDecoderIndex.incrementAndGet() % (long)decoders.length);

        try {
            synchronized(decoders[nIndex]) {
                return decoders[nIndex].decodeBuffer(strData);
            }
        } catch (Exception var4) {
            throw new RuntimeException(var4);
        }
    }
}
