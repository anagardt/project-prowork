package com.draganatasevska.finki.prowork.app.config;

import com.draganatasevska.finki.prowork.web.backend.config.WebBackendConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebBackendConfig.class})
public class AppConfig {

}
