package com.tranbaquan;

import com.tranbaquan.thread.AdmitThread;
import com.tranbaquan.thread.ClassifierThread;
import com.tranbaquan.thread.NotifierThread;

public class KafkaDemoApplication {
    public static void main(String[] args) {

        AdmitThread admitThread = new AdmitThread();
        admitThread.start();

        ClassifierThread classifierThread = new ClassifierThread();
        classifierThread.start();

        NotifierThread notifierThread = new NotifierThread();
        notifierThread.start();
    }
}
