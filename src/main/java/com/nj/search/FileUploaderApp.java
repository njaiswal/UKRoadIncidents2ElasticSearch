package com.nj.search;


import org.apache.camel.spring.Main;

public class FileUploaderApp {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        // enable hangup support so you can press ctrl + c to terminate the JVM
        main.enableHangupSupport();
        main.setApplicationContextUri("applicationContext.xml");

        // run until you terminate the JVM
        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run();

    }

}
