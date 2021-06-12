package com.example.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class XptoController {

    private final String METRIC_NAME = "requisicoes_clientes";
    private final String TAG_NAME = "cliente id";
    MeterRegistry meterRegistry;
    private Map<Integer, Counter> counters = new HashMap<>();

    public XptoController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/xptos")
    public List<Xpto> xptos() {
        List<Xpto> xptos = new ArrayList<>();
        xptos.add(new Xpto(1, "xpty"));
        xptos.add(new Xpto(2, "abc"));
        return xptos;
    }

    @GetMapping("/xptos/{code}")
    public Xpto xpto(@PathVariable int code) {
        Counter counter = counters.get(code);
        if (counter == null) {
            counter = Counter.builder(METRIC_NAME)
                    .tags(TAG_NAME, String.valueOf(code))
                    .register(meterRegistry);
            counters.put(code, counter);
        }
        counter.increment();
        return new Xpto(code, "xpty");
    }
}
