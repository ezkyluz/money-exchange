package pe.com.nttdata.moneyexchange.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pe.com.nttdata.moneyexchange.model.Divisa;
import pe.com.nttdata.moneyexchange.repository.DivisaRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Component
@Slf4j
@Profile("!test")
public class DivisaInitializer implements CommandLineRunner {

    @Autowired
    private DivisaRepository divisaRepository;

    @Override
    public void run(String ... args) {
        initialSetup();
    }

    private List<Divisa> getDataInitial() {
        return Arrays.asList(
                new Divisa(LocalDateTime.of(2022,2,28,9,15,30), 3.80d, 3.9d, "PEN"),
                new Divisa(LocalDateTime.of(2022,2,28,9,30,30), 3.9d, 4d, "PEN"),
                new Divisa(LocalDateTime.of(2022,2,28,9,45,30), 4d, 4.1d, "PEN")
        );
    }

    private void initialSetup() {
        divisaRepository.deleteAll()
                .thenMany(Flux.fromIterable(getDataInitial()))
                .flatMap(divisaRepository::save)
                .thenMany(divisaRepository.findAll())
                .subscribe(divisa -> {});
    }
}
