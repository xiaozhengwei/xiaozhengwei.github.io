package com.utunan;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {

    @Test
    public void demo1() throws IOException {

//        File file = new File("verse.txt");
//        System.out.println(file.exists());

//        FileInputStream fis = new FileInputStream(file);
//        FileChannel inChannel = fis.getChannel();
//
//        FileOutputStream fos = new FileOutputStream(file);
//        FileChannel outChannel = fos.getChannel();

        RandomAccessFile aFile = new RandomAccessFile("verse.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(100);
        int length=-1;
        while((length=inChannel.read(buffer))!=-1){
            buffer.flip();
            System.out.println(buffer.toString());
            for(int i=0;i< buffer.position();i++){
                System.out.print(buffer.get(i)+" ");
            }
            buffer.clear();
        }

    }
}
