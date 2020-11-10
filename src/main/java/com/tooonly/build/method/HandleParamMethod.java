package com.tooonly.build.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HandleParamMethod {

    private static Map<String, MethodHandleEnum> methodMap = new HashMap<>(MethodHandleEnum.values().length);

    static{
        MethodHandleEnum[] methodHandleEnums = MethodHandleEnum.values();
        for (MethodHandleEnum methodHandleEnum : methodHandleEnums) {
            methodMap.put(methodHandleEnum.getMethodName(),methodHandleEnum);
        }
    }

    public static List<MethodHandle> build(Map<String,String[]> map){
        List<MethodHandle> methodHandles = new ArrayList<>();
        for(Map.Entry<String,String[]> entry:map.entrySet()){
            String name = entry.getKey();
            if(methodMap.containsKey(name)){
                MethodHandle methodHandle = methodMap.get(name).getMethodHandle();
                methodHandle.value = entry.getValue();
                methodHandles.add(methodHandle);
            }
        }
        return methodHandles;
    }

    public static void invoke(List<MethodHandle> methods,List<List<Object>> datas){
        if(!methods.isEmpty() && !datas.isEmpty()){
            for(int i = 0;i < datas.size();i++){
                List<Object> data = datas.get(i);
                for(MethodHandle method:methods){
                    method.invoke(data);
                }
            }
        }
    }

}
