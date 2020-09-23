package site.lgong.sample.registry;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.springframework.stereotype.Component;
import site.lgong.framework.registry.ServuceRegistry;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class ServiceRegistryImpl implements ServuceRegistry, Watcher {

    private static CountDownLatch latch = new CountDownLatch(1);
    private static final String REGISTRY_PATH = "/registry";
    private static final int SESSION_TIMEOUT = 500;

    private ZooKeeper zooKeeper;

    public ServiceRegistryImpl(String zkServers) {
        try {
            //创建zookeeper客户端
            zooKeeper = new ZooKeeper(zkServers, SESSION_TIMEOUT, this);
        } catch (IOException e) {
            log.error("创建zookeeper客户端失败", e);
        }
    }

    @Override
    public void process(WatchedEvent event) {
        if (event.getState() == Event.KeeperState.SyncConnected) {
            latch.countDown();
        }
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        String registryPath = REGISTRY_PATH;
        try {
            //创建根节点
            if (zooKeeper.exists(registryPath, false) == null) {
                zooKeeper.create(registryPath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                log.debug("创建根节点： {}", registryPath);
            }
            //创建服务节点
            String servicePath = registryPath + "/" + serviceName;
            if (zooKeeper.exists(servicePath, false) == null) {
                zooKeeper.create(servicePath, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                log.debug("创建服务节点： {}", registryPath);
            }
            //创建地址节点
            String addressPath = servicePath + "/address-";
            String addressNode = zooKeeper.create(addressPath, serviceAddress.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            log.debug("创建地址节点： {} => {}", addressNode, serviceAddress);
        } catch (KeeperException | InterruptedException e) {
            log.error("创建节点失败", e);
        }
    }
}
