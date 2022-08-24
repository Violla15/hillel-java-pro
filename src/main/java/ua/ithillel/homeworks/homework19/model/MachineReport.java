package ua.ithillel.homeworks.homework19.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MachineReport {
    @CsvBindByName(column = "Series_reference")
    private String seriesReference;
    @CsvBindByName(column = "Period")
    @CsvDate("yyyy.MM")
    private Date period;
    @CsvBindByName(column = "Data_value")
    private String dataValue;
    @CsvBindByName(column = "Suppressed")
    private boolean suppressed;
    @CsvBindByName(column = "Status")
    private Status status;
    @CsvBindByName(column = "Units")
    private String units;
    @CsvBindByName(column = "Magnitude")
    private String magnitude;
    @CsvBindByName(column = "Subject")
    private String subject;
    @CsvBindByName(column = "Group")
    private String group;
    @CsvBindByName(column = "Series_title_1")
    private String seriesTitle1;
    @CsvBindByName(column = "Series_title_2")
    private String seriesTitle2;
    @CsvBindByName(column = "Series_title_3")
    private String seriesTitle3;
    @CsvBindByName(column = "Series_title_4")
    private String seriesTitle4;
    @CsvBindByName(column = "Series_title_5")
    private String seriesTitle5;


    @Override
    public String toString() {

        var builder = new StringBuilder();
        builder.append("Machine Report [ ").append(seriesReference).append(", Series reference - ")
                .append(period).append(", Period - ")
                .append(dataValue).append(", Data value - ")
                .append(suppressed).append(", Suppressed - ")
                .append(status).append(", Status - ")
                .append(units).append(", Units - ")
                .append(magnitude).append(", Magnitude - ")
                .append(subject).append(", Subject - ")
                .append(group).append(", Group - ")
                .append(seriesTitle1).append(", Series_title_1 - ")
                .append(seriesTitle2).append(", Series_title_2 - ")
                .append(seriesTitle3).append(", Series_title_3 - ")
                .append(seriesTitle4).append(", Series_title_4 - ")
                .append(seriesTitle5).append(", Series_title_5 - ")
                .append("]");

        return builder.toString();
    }
}
