package DIO;
import java.time.LocalDate;
import java.time.LocalTime;

public class ClockOutRecord {
    private int companyId;
    private LocalDate date;
    private LocalTime time;
    private Double latitude;
    private Double longitude;
    private String memo;

    public ClockOutRecord() {}

    public ClockOutRecord(int companyId, LocalDate date,  String memo) {
        this.companyId = companyId;
        this.date = date;
        this.time = null;
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.memo = memo;
    }

    public ClockOutRecord(int companyId, LocalDate date, LocalTime time,
                          Double latitude, Double longitude, String memo) {
        this.companyId = companyId;
        this.date = date;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.memo = memo;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "ClockOutRecord{" +
                "companyId=" + companyId +
                ", date=" + date +
                ", time=" + time +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", memo='" + memo + '\'' +
                '}';
    }
}
