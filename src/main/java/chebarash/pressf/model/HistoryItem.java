package chebarash.pressf.model;

import java.time.LocalDateTime;

public class HistoryItem {
    private double rate;
    private LocalDateTime date;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}