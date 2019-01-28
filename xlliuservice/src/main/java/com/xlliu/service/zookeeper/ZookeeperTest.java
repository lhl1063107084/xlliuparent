package com.xlliu.service.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuxiaolun
 * @Description: 测试zookeeper
 * @date 2019-01-07 10:51:16
 **/
public class ZookeeperTest implements Watcher {//实现Watcher 监听zookeeper
    private final static Logger logger = LoggerFactory.getLogger(ZookeeperTest.class);

    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();
    /**
     * CountDownLatch是通过一个计数器来实现的，计数器的初始值为线程的数量。
     * 每当一个线程完成了自己的任务后，计数器的值就会减1。
     * 当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
     */
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String a[]) throws Exception {
        //zookeeper 路径
        String path = "/zkPro";
        //连接zookeeper并且注册一个默认的监听器
        zk = new ZooKeeper("127.0.0.1:2181", 5000, (Watcher) new ZookeeperTest());
        countDownLatch.await();//主线程等待,直到countDownLatch计数值为0则继续执行。
        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(zk.getData(path, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {//zk连接成功
            logger.info("boolean {}", Event.KeeperState.SyncConnected == watchedEvent.getState());
            logger.info("Event.KeeperState.SyncConnected = {},watchedEvent.getState = {}", Event.KeeperState.SyncConnected, watchedEvent.getState());
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                countDownLatch.countDown();//countDownLatch计数值减1
            } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {  //zk目录节点数据变化通知事件
                logger.info("watchedEvent.getType = {},Event.EventType.NodeDataChanged = {}", watchedEvent.getType(), Event.EventType.NodeDataChanged);
                try {
                    System.out.println("配置已修改，新值为：" + new String(zk.getData(watchedEvent.getPath(), true, stat)));
                } catch (Exception e) {
                }
            }
        }
    }
}
