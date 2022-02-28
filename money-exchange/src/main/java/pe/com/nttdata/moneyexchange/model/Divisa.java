package pe.com.nttdata.moneyexchange.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("DIVISA")
public class Divisa {

    @Column("date_exchange")
    private LocalDateTime dateExchange;
    private double buy;
    private double sell;

    public LocalDateTime getDateExchange() {
        return dateExchange;
    }

    public void setDateExchange(LocalDateTime dateExchange) {
        this.dateExchange = dateExchange;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getMoneySymbol() {
        return moneySymbol;
    }

    public void setMoneySymbol(String moneySymbol) {
        this.moneySymbol = moneySymbol;
    }

    @Column("money_symbol")
    private String moneySymbol;

    public Divisa(LocalDateTime dateExchange, double buy, double sell, String moneySymbol) {
        this.dateExchange = dateExchange;
        this.buy = buy;
        this.sell = sell;
        this.moneySymbol = "PEN";
    }

    @Override
    public String toString() {
        return "Divisa{" +
                "dateExchange=" + dateExchange +
                ", buy=" + buy +
                ", sell=" + sell +
                ", moneySymbol='" + moneySymbol + '\'' +
                '}';
    }
}
