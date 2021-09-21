// package com.devdezyn.mollysclub.shared.elasticsearch;

// import org.elasticsearch.client.RestHighLevelClient;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.elasticsearch.client.ClientConfiguration;
// import org.springframework.data.elasticsearch.client.RestClients;
// import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
// import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
// import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

// @Configuration
// @EnableElasticsearchRepositories(basePackages = "com.devdezyn.mollysclub.shared.elasticsearch")
// @ComponentScan(basePackages = { "com.devdezyn.mollysclub.shared.elasticsearch" })
// public class ElasticSearchConfig {
//   @Value("${app.elasticsearch.host}")
//   private String elasticHost;

//     @Bean
//     public RestHighLevelClient client() {
//         ClientConfiguration clientConfiguration 
//             = ClientConfiguration.builder()
//                 .connectedTo(elasticHost)
//                 .build();

//         return RestClients.create(clientConfiguration).rest();
//     }

//     @Bean
//     public ElasticsearchOperations elasticsearchTemplate() {
//         return new ElasticsearchRestTemplate(client());
//     }
// }
