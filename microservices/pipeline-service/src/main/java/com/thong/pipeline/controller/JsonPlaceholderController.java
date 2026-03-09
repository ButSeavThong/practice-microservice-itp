package com.thong.pipeline.controller;


import com.thong.pipeline.client.JsonPlaceholderClient;
import com.thong.pipeline.client.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/json-client")
public class JsonPlaceholderController {
    private final JsonPlaceholderClient client;

    @GetMapping
    public List<UserResponse> getUsers() {
        return client.getUsers();
    }

}
