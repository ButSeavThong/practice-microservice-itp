package com.thong.pipeline.client;


import com.thong.pipeline.client.dto.UserResponse;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface JsonPlaceholderClient {

    @GetExchange("/users")
     List<UserResponse> getUsers();
}
