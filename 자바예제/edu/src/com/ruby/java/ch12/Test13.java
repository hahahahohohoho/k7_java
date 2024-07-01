package com.ruby.java.ch12;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test13 {

  public static void main(String[] args) {
    try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("a.zip"))) {
      ZipEntry entry = new ZipEntry("a.txt");
      zos.putNextEntry(entry);
      byte[] data = Files.readAllBytes(Paths.get("a.txt"));
      zos.write(data);

      entry = new ZipEntry("a2.txt");
      zos.putNextEntry(entry);
      zos.write(Files.readAllBytes(Paths.get("a2.txt")));

      entry = new ZipEntry("a3.txt");
      zos.putNextEntry(entry);
      zos.write(Files.readAllBytes(Paths.get("a3.txt")));

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
