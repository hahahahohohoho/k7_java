package com.ruby.java.ch12;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test11 {

  public static void main(String[] args) {
    try(FileOutputStream file = new FileOutputStream("a2.txt"); 
        FileChannel channel = file.getChannel();) {

      int bufferSize = 1024;

      ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

      String str = "And most important, have the courage to follow your heart and intuition.";

      buffer.put(str.getBytes());
      buffer.flip();
      channel.write(buffer);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
