package com.tssconsultancy.structural.composite;

import com.tssconsultancy.structural.composite.model.File;
import com.tssconsultancy.structural.composite.model.Folder;

public class Main {
    public static void main(String[] args) {

        File f1 = new File("file1.txt");
        File f2 = new File("file2.txt");

        Folder subfolder = new Folder("Sub");
        File f3 = new File("file3.txt");
        File f4 = new File("file4.txt");

        Folder folder = new Folder("MyFolder");

        folder.add(f1);
        folder.add(f2);
        subfolder.add(f3);
        subfolder.add(f4);
        folder.add(subfolder);
        folder.showDetails();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        subfolder.showDetails();
    }
}
