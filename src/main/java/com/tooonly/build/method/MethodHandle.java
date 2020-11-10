package com.tooonly.build.method;

public abstract class MethodHandle {

    protected Object value = null;

    abstract public void invoke(Object obj);

}
