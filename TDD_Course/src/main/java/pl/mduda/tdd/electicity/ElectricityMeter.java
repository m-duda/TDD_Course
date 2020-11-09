package pl.mduda.tdd.electicity;

//TODO narzedzie do ustawiania taryfy i stawki

import java.util.Calendar;

public class ElectricityMeter {

    private float kwh = 0;
    private int centsForKwh = 0;

    private boolean tariffOn = false;
    private float kwhTariff = 0;
    private int centsForTariffKwh = 0;

    private int electricityTariffStartHour = 0;
    private int electricityTariffEndHour = 0;

    public void addKwh(float kwhToAdd) {
        if (isTariffNow()) {
            kwhTariff += kwhToAdd;
        } else {
            kwh += kwhToAdd;
        }
    }

    private boolean isTariffNow() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        return hour > electricityTariffStartHour && hour < electricityTariffEndHour;
    }

    public int getHowMoreExpensiveNormalIs() {
        return (centsForKwh * 100 / centsForTariffKwh) - 100;
    }

    void setCentsForKwh(int centsForKwh) {
        this.centsForKwh = centsForKwh;
    }

    void setTariffOn(boolean tariffOn) {
        this.tariffOn = tariffOn;
    }

    void setCentsForTariffKwh(int centsForTariffKwh) {
        this.centsForTariffKwh = centsForTariffKwh;
    }

    void setElectricityTariffStartHour(int electricityTariffStartHour) {
        this.electricityTariffStartHour = electricityTariffStartHour;
    }

    void setElectricityTariffEndHour(int electricityTariffEndHour) {
        this.electricityTariffEndHour = electricityTariffEndHour;
    }
}
