package com.tooonly.build.method;

import java.util.List;

public abstract class MethodHandle {

    private Object value;

    public void invoke(Object object){
        List<Object> data = (List<Object>)object;
        String[] objects = (String[])value;
        if(objects.length > 1){
            invoke(-1,value,data);
            return ;
        }
        String content = ((String[])value)[0];
        String[] values = content.split(",");
        for (String value:
                values) {
            int index = Integer.parseInt(value);
            String param = data.get(index)+"";
            invoke(index,param,data);
        }
    }

    abstract void invoke(int index,Object param,List<Object> data);

    public void setValue(Object value){this.value = value;}

}
