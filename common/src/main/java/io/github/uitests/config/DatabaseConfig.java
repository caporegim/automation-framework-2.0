package io.github.uitests.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:${user.dir}/database.properties")
@Getter
public class DatabaseConfig {
    @Value("${localConnectionString}")
    private String localConnectionString;
    @Value("${devConnectionString}")
    private String devConnectionString;
    @Value("${tstConnectionString}")
    private String tstConnectionString;
    @Value("${uatConnectionString}")
    private String uatConnectionString;
    @Value("${sqaConnectionString}")
    private String sqaConnectionString;
    @Value("${pdtConnectionString}")
    private String pdtConnectionString;
    @Value("${patConnectionString}")
    private String patConnectionString;

    //for dev/test
    @Value("${developer_env_db_username}")
    private String developerEnvDbUsername;
    @Value("${developer_env_db_password}")
    private String developerEnvDbPassword;

    //# Uat/Sqa/Pdt/Pat Automation User Credentials
    @Value("${customer_env_db_username}")
    private String customerEnvDbUsername;
    @Value("${customer_env_db_password}")
    private String customerEnvDbPassword;

    @Value("${local_db_username}")
    private String localDbUsername;
    @Value("${local_db_password}")
    private String localDbPassword;
}
