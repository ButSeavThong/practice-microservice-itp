package com.thongfazon.customerservice.rest;


import com.thongfazon.customerservice.application.config.DeadLetterProcessor;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/dlq")
@RequiredArgsConstructor
public class DlqController {
    private final DeadLetterProcessor deadLetterProcessor;


    @PostMapping("/{processing-group}/any")
    public CompletableFuture<Boolean> processAny( @PathVariable("processing-group") String processinggroup ) {
        return deadLetterProcessor.processorAnyFor(processinggroup);
    }
}
