package com.draganatasevska.finki.prowork.web.backend.config;

import com.draganatasevska.finki.prowork.web.backend.WebComponents;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EntityScan(basePackageClasses = {WebComponents.class})
@ComponentScan(basePackageClasses = {WebComponents.class})
@EnableSwagger2
public class WebBackendConfig {
}
