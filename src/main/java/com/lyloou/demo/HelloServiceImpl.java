package com.lyloou.demo;

import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {
    private static int count;

    @Override
    public String helloString(String para) throws TException {
        return "server:" + para;
    }

    @Override
    public int helloInt(int para) throws TException {
        return 2;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return para;
    }

    @Override
    public void helloVoid() throws TException {
        count++;
        System.out.println("server: helloVoid: " + count);
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }
}
