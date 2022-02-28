package pe.com.nttdata.moneyexchange.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.com.nttdata.moneyexchange.dto.DivisaSellDto;
import pe.com.nttdata.moneyexchange.model.Divisa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DivisaRepository extends ReactiveCrudRepository<Divisa, LocalDateTime> {

    @Query("select trunc(date_exchange) as date, MAX(sell) sell from Divisa where trunc(date_exchange) = trunc($1) group by trunc(date_exchange)")
    Mono<DivisaSellDto> findByLowDate(LocalDateTime date1);

    @Query("select trunc(date_exchange) as date, MIN(sell) sell from Divisa where trunc(date_exchange) = trunc($1) group by trunc(date_exchange)")
    Mono<DivisaSellDto> findByHighDate(LocalDateTime date1);

    @Query("select trunc(date_exchange) as date, avg(sell) sell from Divisa where trunc(date_exchange) = trunc($1) group by trunc(date_exchange)")
    Mono<DivisaSellDto> findByMediumDate(LocalDateTime date1);

    @Query("select * from Divisa")
    Flux<Divisa> findByDateExchange();

}
