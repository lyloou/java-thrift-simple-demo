package com.lyloou.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class HelloServiceClient {
    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("localhost", 9001);
            transport.open();
            Hello.Client client = new Hello.Client(new TBinaryProtocol(transport));
            boolean b = client.helloBoolean(true);
            System.out.println(b);
            client.helloVoid();
            System.out.println(client.helloString("heeeldksj"));
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
