package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: day03_eesy_05annotationAOP
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/29 16:44
 */

@Configuration
@ComponentScan(basePackages = "com.itheima")
@EnableAspectJAutoProxy
public class SpringConfiguration {
    /**
     * 如果需要完全省略bean.xml文件,只需要使用@ComponentScan和@EnableAspectJAutoProxy注解标签
     */
}
