package site.lgong.framework.registry;

/**
 * 服务注册表
 */
public interface ServuceRegistry {

    /**
     * 注册服务信息
     *
     * @param serviceName
     * @param serviceAddress
     */
    void register(String serviceName, String serviceAddress);

}
