package com.liugs.httplib;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager {

    //任务队列
    private LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    //添加任务
    public void execute(Runnable runnable){
        if (runnable != null){
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //把队列中的任务放入线程池
    private ThreadPoolExecutor threadPoolExecutor;

    private ThreadPoolManager(){
        threadPoolExecutor = new ThreadPoolExecutor(5,10,15, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(4), rejectedExecutionHandler);
        threadPoolExecutor.execute(runable);
    }

    private RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 参数r就是超时的线程任务
            if (r != null){
                try {
                    queue.put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    // 开始工作
    private  final Runnable runable = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Runnable take = queue.take();
                    if (take != null){
                        threadPoolExecutor.execute(take);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static class Holder{
        static final ThreadPoolManager instance = new ThreadPoolManager();
    }

    public static ThreadPoolManager getInstance(){
        return Holder.instance;
    }

}
