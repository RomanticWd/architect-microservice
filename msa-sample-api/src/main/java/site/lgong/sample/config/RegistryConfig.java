package site.lgong.sample.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.lgong.framework.registry.ServiceRegistry;
import site.lgong.sample.registry.ServiceRegistryImpl;

/**
 * 创建ServiceRegistry对象
 */
@Setter
@Configuration
@ConfigurationProperties(prefix = "registry")
public class RegistryConfig {

    /**
     * ConfigurationProperties指定前缀registry，将读取application.yml配置文件中的registry.servers属性
     * 并初始化到ServiceRegistry对象中
     */
    private String servers;

    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistryImpl(servers);
    }

}
