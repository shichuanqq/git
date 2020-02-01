package com.example.demo.config.deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 死锁检测
 */
public class DeadLockChecker {

    private final static ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();

    public static void check() {
        Thread thread = new Thread(() -> {
            while (true) {
                long[] deadlockedThreads = mxBean.findDeadlockedThreads();
                if (deadlockedThreads != null) {
                    ThreadInfo[] threadInfo = mxBean.getThreadInfo(deadlockedThreads);
                    for (Thread t : Thread.getAllStackTraces().keySet()) {
                        for (int i = 0; i < threadInfo.length; i++) {
                            if (t.getId() == threadInfo[i].getThreadId()) {
                                t.interrupt();
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true); //守护线程
        thread.start();
    }

}
