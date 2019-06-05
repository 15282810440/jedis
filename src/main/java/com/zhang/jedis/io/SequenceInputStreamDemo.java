package com.zhang.jedis.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 序列流
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        //	File f = new File("e:");
        //建立文件输入集合
        Vector<FileInputStream> v = new Vector<FileInputStream>();
        //输入文件
        v.add(new FileInputStream("E:/1.txt"));
        v.add(new FileInputStream("E:/2.txt"));
        //获取文件
        Enumeration<FileInputStream> en = v.elements();
        //合并流
        SequenceInputStream sis = new SequenceInputStream(en);
        //合并后文件
        FileOutputStream fos = new FileOutputStream("E:/4.txt");

        byte[] buf = new byte[1024];
        int len = 0;
        //合并操作
        while((len = sis.read(buf))!=-1){
            fos.write(buf,0,len);
        }
        fos.close();
        sis.close();

    }
}
