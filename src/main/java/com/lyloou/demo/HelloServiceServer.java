package com.lyloou.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServiceServer {
    public static void main(String[] args) {
        try {
            TServerSocket socket = new TServerSocket(9001);
            TThreadPoolServer server = new TThreadPoolServer(new TThreadPoolServer.Args(socket)
                    .processor(new Hello.Processor<>(new HelloServiceImpl()))
                    .protocolFactory(new TBinaryProtocol.Factory()));
            System.out.println("start server on port 9001 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
