package zookeeper;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

public class ZookeeperTest {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZookeeperConncet zookeeperConncet = new ZookeeperConncet();
        zookeeperConncet.connectZooKeeper("182.92.112.35:2181");
        List<String> children = zookeeperConncet.getChildren("/");
        System.out.println(children);
    }
}
