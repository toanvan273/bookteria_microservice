//package com.devteria.profile.config;
//
//import org.neo4j.cypherdsl.core.renderer.Configuration;
//import org.springframework.context.annotation.Bean;
//
//public class Neo4jConfig {
//    @Bean
//    public Configuration getConfiguration() {
//        return new Configuration.Builder()
//                .credentials("neo4j", "secret")
//                .uri("bolt://localhost:7687").build();
//    }
//
////    @Bean
////    public SessionFactory sessionFactory(org.neo4j.ogm.config.Configuration configuration) {
////        return new SessionFactory(configuration,
////                "<your base package>");
////    }
//}
