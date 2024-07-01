package com.ruby.java.ch12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Test14 {

  public static void main(String[] args) {
    try(ZipInputStream zis = new ZipInputStream(new FileInputStream("a.zip"))) {
      ZipEntry entry = null;
      while((entry = zis.getNextEntry()) != null) {

        try(FileOutputStream out = new FileOutputStream("c:\\work\\" + entry.getName())) {
          byte[] buf = new byte[1024];
          int len = 0;
          while((len = zis.read(buf)) != -1) {
            out.write(buf, 0, len);
          }
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
