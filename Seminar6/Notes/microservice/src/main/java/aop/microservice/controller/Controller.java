package aop.microservice.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping()
public class Controller {

    @GetMapping
    public String Hello(){return "Hello";}

    private final Counter httpRequestsCounter = Metrics.counter("http.requests.total");
    @GetMapping("/api/some-endpoint")
    public ResponseEntity<String> someEndpoint() {
        httpRequestsCounter.increment();
        return ResponseEntity.ok("Success");
    }
}

