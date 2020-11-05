package com.tooonly.util.security;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;
import java.util.concurrent.atomic.AtomicLong;

public class CDOAes extends AES {
    private Cipher[] encoders;
    private Cipher[] decoders;
    private int nInstanceCount;
    private AtomicLong alEncodeIndex;
    private AtomicLong alDecodeIndex;

    public CDOAes() {
        this(1);
        init();
    }

    public CDOAes(int nInstanceCount) {
        this.encoders = null;
        this.decoders = null;
        this.nInstanceCount = 1;
        this.alEncodeIndex = null;
        this.alDecodeIndex = null;
        this.nInstanceCount = nInstanceCount;
        this.encoders = new Cipher[nInstanceCount];
        this.decoders = new Cipher[nInstanceCount];
        this.alEncodeIndex = new AtomicLong(0L);
        this.alDecodeIndex = new AtomicLong(0L);
    }

    public void init(String strPassword) {
        String[] strsItem = AES.splitString(strPassword, '|');
        if (strsItem.length != 2) {
            throw new RuntimeException("Invalid AES password: " + strPassword);
        } else {
            this.init(strsItem[0], strsItem[1]);
        }
    }

    public void init(){
        init("hQFmTvJ3lqwfB1xW", "kpPnCaOljeWCamnrY16Y7MeIKoogfQYN");
    }

    public void init(String strKey, String strIV) {
        if (strKey.length() < 16) {
            throw new RuntimeException("Key length must be at least 16");
        } else if (strIV.length() < 16) {
            throw new RuntimeException("IV length must be at least 16");
        } else {
            try {
                strKey = strKey.substring(0, 16);
                strIV = strIV.substring(0, 16);
                byte[] keyBytes = strKey.getBytes("utf-8");
                Security.addProvider(new BouncyCastleProvider());
                SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
                byte[] bysIV = strKey.getBytes("utf-8");
                IvParameterSpec iv = new IvParameterSpec(bysIV);

                for(int i = 0; i < this.nInstanceCount; ++i) {
                    this.encoders[i] = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
                    this.encoders[i].init(1, key, iv);
                    this.decoders[i] = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
                    this.decoders[i].init(2, key, iv);
                }

            } catch (Exception var8) {
                for(int i = 0; i < this.nInstanceCount; ++i) {
                    this.encoders[i] = null;
                    this.decoders[i] = null;
                }

                throw new RuntimeException(var8);
            }
        }
    }

    public byte[] encode(byte[] bysContent) {
        int nIndex = (int)(this.alEncodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.encoders[nIndex] == null) {
            return bysContent;
        } else {
            try {
                byte[] bysResult = null;
                synchronized(this.encoders[nIndex]) {
                    bysResult = this.encoders[nIndex].doFinal(bysContent);
                }

                return bysResult;
            } catch (Exception var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    public String encode(String strText) {
        int nIndex = (int)(this.alEncodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.encoders[nIndex] == null) {
            return strText;
        } else {
            try {
                byte[] byteContent = strText.getBytes("utf-8");
                byte[] bysResult = null;
                synchronized(this.encoders[nIndex]) {
                    bysResult = this.encoders[nIndex].doFinal(byteContent);
                }

                String strResult = Base64.encode(bysResult);
                return strResult;
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public byte[] decode(byte[] bysEncoded) {
        int nIndex = (int)(this.alDecodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.decoders[nIndex] == null) {
            return bysEncoded;
        } else {
            try {
                byte[] bysResult = null;
                synchronized(this.decoders[nIndex]) {
                    bysResult = this.decoders[nIndex].doFinal(bysEncoded);
                }

                return bysResult;
            } catch (Exception var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    public String decode(String strEncoded) {
        int nIndex = (int)(this.alDecodeIndex.incrementAndGet() % (long)this.nInstanceCount);
        if (this.decoders[nIndex] == null) {
            return strEncoded;
        } else {
            byte[] bysEncoded = Base64.decode(strEncoded);

            try {
                byte[] bysResult = null;
                synchronized(this.decoders[nIndex]) {
                    bysResult = this.decoders[nIndex].doFinal(bysEncoded);
                }

                String strResult = new String(bysResult, "utf-8");
                return strResult;
            } catch (Exception var7) {
                throw new RuntimeException(var7);
            }
        }
    }

    public static void main(String[] args) {
        AES aes = new CDOAes();
        String decode = aes.decode("M+7GIizh/QseV4kp1+lbF47V6/puD1ikwEXAEUJ7gLs=");
        System.out.println(decode);
    }
}

