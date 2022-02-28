package pe.com.nttdata.moneyexchange.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.moneyexchange.dto.DivisaDto;
import pe.com.nttdata.moneyexchange.dto.DivisaSellDto;
import pe.com.nttdata.moneyexchange.model.Divisa;
import pe.com.nttdata.moneyexchange.service.DivisaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/money-exchange/v1")
public class DivisaController {

    @Autowired DivisaService divisaService;

    @PostMapping("/exchange")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Divisa> create(@RequestBody DivisaDto divisaDto) {
        StopWatch watch = new StopWatch();
        Mono<Divisa> flow;
        try {
            watch.start();
            flow = divisaService.createDivisa(divisaDto);
        } finally {
            watch.stop();
        }
        System.out.println("POST-exchange/ time elapsed: " + watch.prettyPrint());
        return flow;
    }

    @GetMapping("/exchange/{profile}")
    public Mono<DivisaSellDto> getDivisaByProfile(@PathVariable String profile, @RequestParam(value = "date", required = false) String date) {
        StopWatch watch = new StopWatch();
        Mono<DivisaSellDto> flow;
        try {
            watch.start();
            String suffix = " 00:00:00";
            flow = divisaService.getDivisa(profile, LocalDateTime.parse( date+suffix, DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss")));
        } finally {
            watch.stop();
        }
        System.out.println("GET exchange/ time elapsed: " + watch.prettyPrint());
        return flow;
    }

    @GetMapping("/exchange/realtime")
    public Flux<Divisa> getDivisaByProfile() {
        StopWatch watch = new StopWatch();
        Flux<Divisa> flow;
        try {
            watch.start();
            flow = divisaService.getDivisaByDateExchange();
        } finally {
            watch.stop();
        }
        System.out.println("GET exchange/realtime time elapsed: " + watch.prettyPrint());
        return flow;
    }
}
