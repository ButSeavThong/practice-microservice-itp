package com.thong.pipeline.config;

import com.thong.pipeline.client.AccountClient;
import com.thong.pipeline.client.JsonPlaceholderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HttpInterfaceConfig {

    String jsonURL = "https://jsonplaceholder.typicode.com";
    String accountURL = "http://account";

   @Bean
   public JsonPlaceholderClient jsonPlaceholderClient(HttpInterfaceFactory factory) {
       return factory.createNormalClient(jsonURL,JsonPlaceholderClient.class);
   }


   @Bean
   public AccountClient accountClient( HttpInterfaceFactory factory ) {
       return factory.createClient(accountURL, AccountClient.class);
   }
}
