package config;

import org.springframework.context.annotation.*;


/**
 * @program: day02_eesy_04account_annoioc_withoutxml
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/28 14:57
 */

@Configuration
@ComponentScan(basePackages = "com.itheima")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
