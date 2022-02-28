package pe.com.nttdata.moneyexchange.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.com.nttdata.moneyexchange.dto.DivisaDto;
import pe.com.nttdata.moneyexchange.model.Divisa;

@Mapper
public interface DivisaMapper {

    DivisaMapper INSTANCE = Mappers.getMapper( DivisaMapper.class );

    @Mapping(source = "date", target = "dateExchange", dateFormat = "yyyy/MM/dd HH:mm:ss")
    @Mapping(source="buy", target = "buy", numberFormat = "#.00")
    @Mapping(source="sell", target = "sell", numberFormat = "#.00")
    Divisa divisaDtoToDivisa(DivisaDto divisaDto);

    @InheritInverseConfiguration
    DivisaDto divisaToDivisaDto(Divisa divisa);
}
