package pe.com.nttdata.moneyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.nttdata.moneyexchange.dto.DivisaDto;
import pe.com.nttdata.moneyexchange.dto.DivisaSellDto;
import pe.com.nttdata.moneyexchange.mapper.DivisaMapper;
import pe.com.nttdata.moneyexchange.model.Divisa;
import pe.com.nttdata.moneyexchange.repository.DivisaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class DivisaService {

    @Autowired
    private DivisaRepository divisaRepository;

    public Mono<Divisa> createDivisa(DivisaDto divisaDto) {
        Divisa divisa = DivisaMapper.INSTANCE.divisaDtoToDivisa(divisaDto);
        return divisaRepository.save(divisa);
    }

    public Mono<DivisaSellDto> getDivisa(String profile, LocalDateTime date) {
        switch (profile) {
            case "LOW":
                return divisaRepository.findByLowDate(date);
            case "MEDIUM":
                return divisaRepository.findByMediumDate(date);
            case "HIGH":
            default:
                return divisaRepository.findByHighDate(date);
        }
    }

    public Flux<Divisa> getDivisaByDateExchange() {
        return divisaRepository.findByDateExchange();
    }


}
