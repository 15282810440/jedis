package com.zhang.jedis.io;

import java.io.*;

//准备写入的对象,必须实现Serializable接口,标记接口
class Student implements Serializable
{

    public static final long serialVersionUID = 1L;//如果类发生改变,只要ID不变,默认为一个类

    private String name;
    transient private int age;//transient参数,有的话,就不写入
    Student(String name ,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name+"  "+age;
    }
}

class ObjectIODemo
{
    public static void main(String[] args) throws Exception{
        //读取
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/Object.txt"));
        Student student = new Student("xiaoming",22);
        oos.writeObject(student);
        oos.close();
        //输入
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/Object.txt"));
        Student p = (Student)ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
