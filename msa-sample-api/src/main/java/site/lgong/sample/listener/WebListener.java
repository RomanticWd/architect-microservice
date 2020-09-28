package site.lgong.sample.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import site.lgong.framework.registry.ServiceRegistry;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * 应用初始化的时候进行服务注册
 */
@Configuration
public class WebListener implements ServletContextListener {

    @Value("${server.address}")
    private String serverAddress;

    @Value("${server.port}")
    private int serverPort;

    @Resource
    private ServiceRegistry serviceRegistry;

    @Override
    public void contextInitialized(ServletContextEvent event) {

        //获取请求映射
        //获取ServletContext对象
        ServletContext servletContext = event.getServletContext();
        //获取applicationContext对象
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        //获取RequestMappingHandlerMapping对象
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取RequestMapping注解修饰的所有方法
        Map<RequestMappingInfo, HandlerMethod> infoMap = mapping.getHandlerMethods();
        for (RequestMappingInfo info : infoMap.keySet()) {
            String serviceName = info.getName();
            //name不为空时候进行服务注册
            if (serviceName != null) {
                //注册服务
                serviceRegistry.register(serviceName, String.format("%s:%d", serverAddress, serverPort));
            }
        }
    }
}
