package com.tranbaquan.thread;

import com.tranbaquan.stream.StudentClassifier;

public class ClassifierThread extends Thread {

    @Override
    public void run() {
        new StudentClassifier().classify();
    }
}
