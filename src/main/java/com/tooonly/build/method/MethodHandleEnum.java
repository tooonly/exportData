package com.tooonly.build.method;

import com.tooonly.util.security.AES;
import com.tooonly.util.security.CDOAes;

import java.util.List;

public enum MethodHandleEnum {

    CDOAES("cdoAes",new MethodHandle(){
        @Override
        public void invoke(Object object) {
            List<Object> data = (List<Object>)object;
            String content = ((String[])value)[0];
            String[] values = content.split(",");
            for (String value:
                 values) {
                int index = Integer.parseInt(value);
                String param = data.get(index)+"";
                param = aes.decode(param);
                data.set(index,param);
            }
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
