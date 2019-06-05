package com.zhang.jedis.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流  管道流在写入的时候 读取流就会读取到
 */
class Read implements Runnable
{
    private PipedInputStream in;
    Read(PipedInputStream in){
        this.in = in;
    }
    public void run(){
        try{
            byte[] buf = new byte[1024];

            int len = in.read(buf);

            String s = new String(buf ,0,len);
            System.out.println(s);
            in.close();
        }catch(Exception e){
        }
    }
}
//写入
class Write implements Runnable
{
    private PipedOutputStream out;
    Write(PipedOutputStream out){
        this.out = out;
    }
    public void run(){
        try{

            out.write("管道".getBytes());
            out.close();
        }catch(Exception e){
        }
    }
}

class PipedIODemo
{
    public static void main(String[] args) throws IOException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();
        in.connect(out);

        Thread t1 = new Thread(new Read(in));
        Thread t2 = new Thread(new Write(out));
        t1.start();
        t2.start();
    }
}
