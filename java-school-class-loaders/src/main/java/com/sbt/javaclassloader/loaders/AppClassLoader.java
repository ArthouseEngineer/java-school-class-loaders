package com.sbt.javaclassloader.loaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppClassLoader extends ClassLoader {

    private String pathToBinary = "target" + "\\" + "classes";


    public AppClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(pathToBinary, name.replace(".", "/") + ".class");
        System.out.println(f.toString());
        try {
            byte b[] = loadClassData(f.toString());
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            return super.findClass(name);
        }
    }


    private byte[] loadClassData(String name) throws  IOException {
        byte[] data = Files.readAllBytes(Paths.get(name));
        return data;
    }
}
