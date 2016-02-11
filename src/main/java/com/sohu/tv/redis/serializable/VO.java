package com.sohu.tv.redis.serializable;


import java.io.Serializable;

public class VO<T> implements Serializable {

    private T value;

    public VO(T value) {
        this.value = value;
    }

    public VO() {
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "VO{" +
                "value=" + value +
                '}';
    }
}
