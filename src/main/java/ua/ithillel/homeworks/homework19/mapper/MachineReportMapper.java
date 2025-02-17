package ua.ithillel.homeworks.homework19.mapper;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.Getter;
import lombok.Setter;
import ua.ithillel.homeworks.homework19.model.MachineReport;
import ua.ithillel.homeworks.homework19.model.Status;


import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MachineReportMapper implements ReportMapper<MachineReport> {
    private List<MachineReport> machineReports = new ArrayList<>();
    private List<MachineReport> listStatus_F = new ArrayList<>();
    private List<MachineReport> listStatus_R = new ArrayList<>();
    private List<MachineReport> listStatus_C = new ArrayList<>();

    @Override
    public List<MachineReport> readAll(Path path) {
        List<MachineReport> reportList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<MachineReport> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(MachineReport.class);

            CsvToBean<MachineReport> csvToBean = new CsvToBeanBuilder<MachineReport>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            reportList = csvToBean.parse();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        machineReports.addAll(reportList);
        return reportList;
    }

    @Override
    public void populateMap(Map<Status, List<MachineReport>> map, List<MachineReport> machineReports) {

        for (MachineReport machineReport : machineReports) {
            if (machineReport.getStatus() == Status.C) {
                listStatus_C.add(machineReport);
            }
            if (machineReport.getStatus() == Status.R) {
                listStatus_R.add(machineReport);
            }
            if (machineReport.getStatus() == Status.F) {
                listStatus_F.add(machineReport);
            }
        }
        map.put(Status.F, listStatus_F);
        map.put(Status.R, listStatus_R);
        map.put(Status.C, listStatus_C);
    }


    @Override
    public void populateMapParallel
            (Map<Status, List<MachineReport>> map, List<MachineReport> machineReports)
            throws InterruptedException {

        Thread tread = new Thread(() ->
                populateMap(map, machineReports.subList(0, machineReports.size() >> 2)));

        Thread tread2 = new Thread(() ->
                populateMap(map, machineReports.subList(machineReports.size() >> 2, machineReports.size())));

        tread.start();
        tread.join();
        tread2.start();
        tread2.join();
    }
}
