package edu.mum.week1ExtraCredit.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyFileReader {

    public  byte[] fileByteArray(String file) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
       // File file = new File(classLoader.getResource("").getFile());
        //classLoader.getResource("").toString()
        Path p = FileSystems.getDefault().getPath("",file );
        return Files.readAllBytes(p);
    }
}
