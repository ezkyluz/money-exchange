package pe.com.nttdata.moneyexchange.dto;

import java.time.LocalDateTime;

public class DivisaSellDto {

    private double sell;
    private LocalDateTime date;
    private String moneySymbol;

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMoneySymbol() {
        return moneySymbol;
    }

    public void setMoneySymbol(String moneySymbol) {
        this.moneySymbol = moneySymbol;
    }

    public DivisaSellDto(LocalDateTime date,double sell) {
        this.sell = sell;
        this.date = date;
        this.moneySymbol="PEN";
    }

    @Override
    public String toString() {
        return "DivisaSellDto{" +
                "sell=" + sell +
                ", date='" + date + '\'' +
                ", moneySymbol='" + moneySymbol + '\'' +
                '}';
    }
}
