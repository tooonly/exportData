package com.tooonly.build.method;

import com.tooonly.util.security.AES;
import com.tooonly.util.security.CDOAes;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;

public enum MethodHandleEnum {

    CDOAES("cdoAes",new MethodHandle(){
        @Override
        public void invoke(int index,Object param,List<Object> data) {
            param = aes.decode(param+"");
            data.set(index, param);
        }
    }),

    FORMAT_NUM("formatNum", new MethodHandle() {
        @Override
        public void invoke(int index,Object param,List<Object> data) {
            Number bigDecimal = new BigDecimal(param+"").divide(new BigDecimal(100));
            Format df = new DecimalFormat("#,###.00");
            String result = df.format(bigDecimal);
            data.set(index,result);
        }
    });


    private static AES aes = new CDOAes();
    private static AES cdoAes = new CDOAes();
    private MethodHandle methodHandle;
    private String methodName;

    private MethodHandleEnum(String methodName,MethodHandle methodHandle){
        this.methodName = methodName;
        this.methodHandle = methodHandle;
    }

    public String getMethodName(){
        return this.methodName;
    }

    public MethodHandle getMethodHandle(){
        return this.methodHandle;
    }



}
