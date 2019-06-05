package com.zhang.jedis.io;


import java.io.*;

public class TestOutPutIO {

    public static void main(String[] args) throws IOException {
        TestOutPutIO testOutPutIO = new TestOutPutIO();
        testOutPutIO.PrintWriter();
    }

    /**
     * 打印流
     */
    public void PrintWriter(){
      try{
          //输入
          //BufferedInputStream cin = new BufferedInputStream(System.in);
          BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
          //字符输出流
          PrintWriter out = new PrintWriter("E:/text.txt");
          //字节输出流
          //PrintStream out = new PrintStream("a.txt");
          String line = null;
          while((line = cin.readLine())!=null){
              out.println(line);
              out.flush();

          }
          out.close();
          cin.close();
      }catch (Exception e){
            e.printStackTrace();
      }finally {

      }
    }





    /**
     * 字符缓冲输出流
     */
    public void bufferedOutputReader()  {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedWriter bufferedWriter  = null;
        try {
            String content = "bufferedOutputReader";
            String filePath = "E:/text.txt";
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            bufferedWriter.write(content);
            bufferedWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字符缓冲输入流
     */
    public void bufferedInputReader()  {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader  = null;
        try {
            String filePath = "E:/text.txt";
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            int len = 0;
            char[] buff = new char[1024];
            while((len=bufferedReader.read(buff)) != -1){
                stringBuffer.append(new String(buff,0,len));
            }
            System.out.println(stringBuffer);
        }catch (Exception e){

        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 字节缓冲输出流
     */
    public void bufferedInputStream()  {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedInputStream bufferedInputStream  = null;
        try {
            String filePath = "E:/text.txt";
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
            int len = 0;
            byte[] buff = new byte[1024];
            while((len=bufferedInputStream.read(buff)) != -1){
                stringBuffer.append(new String(buff,0,len));
            }
            System.out.println(stringBuffer);
        }catch (Exception e){

        }finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字节缓冲输出流
     */
    public void bufferedOutputStream()  {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedOutputStream bufferedOutputStream  = null;
        try {
            String content = "bufferedOutputStream";
            String filePath = "E:/text.txt";
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            bufferedOutputStream.write(content.getBytes());
        }catch (Exception e){

        }finally {
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 字符输入流
     * @throws IOException
     */
    public void charInput() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String filePath = "E:/text.txt";
        FileReader inputStream = new FileReader(filePath);
        char [] buff =  new char[1024];
        int len = 0;
        while((len = inputStream.read(buff)) != -1){
            stringBuffer.append(new String(buff, 0, len));
        }
        System.out.println(stringBuffer.toString());
        inputStream.close();
    }


    /**
     * 字节输入流
     * @throws IOException
     */
    public void input() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        String filePath = "E:/text.txt";
        FileInputStream inputStream = new FileInputStream(filePath);
        byte [] buff =  new byte[1024];
        int len = 0;
        while((len = inputStream.read(buff)) != -1){
            stringBuffer.append(new String(buff, 0, len));
        }
        System.out.println(stringBuffer.toString());
        inputStream.close();
    }

    /**
     * 字节输出流
     * @throws IOException
     */
    public void charOutput() throws IOException {
        String text = "输出测试1111";
        String filePath = "E:/text.txt";
        FileWriter outputStream = null;
        outputStream = new FileWriter(filePath);
        outputStream.write(text);
        outputStream.close();
    }


    /**
     * 字节输出流
     * @throws IOException
     */
    public void output() throws IOException {
        String text = "输出测试";
        String filePath = "E:/text.txt";
        FileOutputStream outputStream = null;
        outputStream = new FileOutputStream(filePath);
        outputStream.write(text.getBytes());
        outputStream.close();
    }

}
