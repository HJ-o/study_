//package com.edwith.common.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class DBConfig {
//	private String driverClassName = "com.mysql.jdbc.Driver";
//    private String url = "jdbc:mysql://localhost:3306/reservation?useUnicode=true&characterEncoding=utf8";
//
//    private String username = "root";
//    private String password = "0203";
//
//    @Bean
//    public DataSource dataSource() {
//    	BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//
//    }
//}
