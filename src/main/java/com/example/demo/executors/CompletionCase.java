package com.example.demo.executors;

import sun.tools.jconsole.Worker;

import java.util.concurrent.*;

public class CompletionCase {

    public static void main(String[] args) throws Exception {
        testByCompletion();
    }

    private static void testByCompletion() throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(20);

        //保证队列的顺序 （先完成的先拿到）
        CompletionService<Integer> cService = new ExecutorCompletionService<>(pool);

        for (int i = 0; i < 20; i++) {
            cService.submit(new WorkTask("Task" + i, i));
        }

        for (int i = 0; i < 20; i++) {
            Integer integer = cService.take().get();
            System.out.println(integer);
        }

        pool.shutdownNow();

    }

    public static class WorkTask implements Callable<Integer> {

        private String name;

        private Integer i;

        public WorkTask(String name, Integer i) {
            this.name = name;
            this.i = i;
        }

        @Override
        public Integer call() throws Exception {
            return i;
        }
    }
}
