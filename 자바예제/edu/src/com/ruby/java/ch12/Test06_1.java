package com.ruby.java.ch12;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test06_1 {

  public static void main(String[] args) {

    try {

      // 디렉터리 생성
      Path dir = Paths.get("c:", "work2", "subDir");
      Files.createDirectories(dir);

      // 파일 생성
      Path file1 = Paths.get("c:\\work2\\file1.txt");
      Files.createFile(file1);

      // File을 Path로 변환
      File f1 = new File("c:\\work2\\file1.txt");
      Path p1 = f1.toPath();

      // Path를 File로 변환
      File f2 = file1.toFile();

      Path file2 = dir.resolve("file2.txt");
      Path normalPath = file2.normalize();  // 정규화된 경로
      Path root = file2.getRoot();          // root 경로
      Path parent = file2.getParent();      // parent 경로
      System.out.println("Path normalize : " + normalPath);
      System.out.println("root 경로 : " + root);
      System.out.println("parent 경로 : " + parent);

      if(Files.exists(file1)) {  // 경로가 존재하는지 검사
        System.out.println(file1 + " 존재");
        try(PrintWriter out = new PrintWriter(f2)) {
          out.println("hello java!");
        }
      }

      if(Files.notExists(file2)) {  // 경로가 존재하지 않는지 검사
        System.out.println(file2 + " 존재하지 않음");
      }

      Path file3 = dir.resolve("file3.txt");
      Files.copy(file1, file3);  // 파일 복사
      // Files.delete(file3);    // 파일 삭제

    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}

