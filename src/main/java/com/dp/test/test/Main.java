package com.dp.test.test;

import java.io.*;

/**
 * @author Ldp
 * @date 2021/11/30
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        bufferedWriter();
//        fileReader();
        fileReader1();
    }

    public void fileWriter() throws IOException {
        FileWriter fileWriter = new FileWriter("text.txt",true);
        fileWriter.write("1ggg");
        fileWriter.close();
    }

    public static void bufferedWriter()throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("text.txt"));
        bufferedWriter.write("sss");
        bufferedWriter.newLine();
        char[] c = {'你','真','好'};
        bufferedWriter.write(c);
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    /* 读取  */


    public static void fileReader() throws IOException {
        FileReader fileReader = new FileReader("text.txt");
        int read = 0;
        while ((read = fileReader.read())!= -1){
            System.out.println((char)read);
        }
        fileReader.close();
    }

    /*第二种方式：通过字符数组进行读取。*/

    public static void fileReader1()throws IOException {
        FileReader fr = new FileReader("text.txt");

        //定义一个字符数组。用于存储读到字符。
        //该read(char[])返回的是读到字符个数。
        char[] buf = new char[1024];

        int num = 0;
        while((num=fr.read(buf))!=-1) {
            System.out.println(new String(buf,0,num));
        }
        fr.close();
    }
}
