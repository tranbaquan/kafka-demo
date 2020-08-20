package com.tranbaquan.thread;

import com.tranbaquan.stream.StudentNotifier;

public class NotifierThread extends Thread {

    @Override
    public void run() {
        new StudentNotifier().writeLog();
    }
}
