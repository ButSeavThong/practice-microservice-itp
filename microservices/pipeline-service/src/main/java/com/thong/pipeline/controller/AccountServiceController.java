package com.thong.pipeline.controller;


import com.thong.pipeline.client.AccountClient;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/pipeline-account")
public class AccountServiceController {
    private final AccountClient accountClient;
    private final CircuitBreaker circuitBreaker;

    public AccountServiceController(AccountClient accountClient, CircuitBreakerRegistry registry) {
       this.accountClient = accountClient;
       circuitBreaker = registry.circuitBreaker("account");
    }


    @GetMapping("/all")
//    @CircuitBreaker(name = "accountCircuitBreaker", fallbackMethod = "fallBack")
    public Map<String, Object> getAccounts() {
//        return  accountClient.getAccounts();

        log.debug("getAccounts");

        try{
            return circuitBreaker.executeSupplier(accountClient::getAccounts);
        }catch (CallNotPermittedException exception){
            return Map.of("ERROR DATA", exception.getMessage());
        }catch (Exception exception){
            return Map.of("ERROR DATA", exception.getMessage());
        }

    }

//    public  String message = "Account is busy !";
//    Map<String, Object> fallBack(Throwable ex) {
//        return Map.of("message", ex.getMessage()
//        ,
//                "message-1",message);
//    }

}
