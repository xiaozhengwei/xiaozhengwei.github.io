package com.utunan;

import org.junit.jupiter.api.Test;

import java.nio.IntBuffer;

public class BufferDemo {
    @Test
    public void demo1() {

        IntBuffer buffer = IntBuffer.allocate(20);
        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        for (int i = 0; i < 5; i++) {
            buffer.put(i);
        }

        buffer.put(5,1);

        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        buffer.flip();

        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

        int a=buffer.get();

        System.out.println(a);
        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

    }
}
