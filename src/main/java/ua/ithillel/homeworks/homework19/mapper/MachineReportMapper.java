package ua.ithillel.homeworks.homework19.mapper;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import ua.ithillel.homeworks.homework19.model.MachineReport;
import ua.ithillel.homeworks.homework19.model.Status;


import java.io.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;


import static ua.ithillel.homeworks.homework19.Homework19.*;

public class MachineReportMapper implements ReportMapper<MachineReport> {


    @Override
    public List<MachineReport> readAll(Path path) {
        try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<MachineReport> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(MachineReport.class);

            CsvToBean<MachineReport> csvToBean = new CsvToBeanBuilder<MachineReport>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            machineReports = csvToBean.parse();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return machineReports;
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
    public void populateMapParallel(Map<Status, List<MachineReport>> map, List<MachineReport> machineReports)
            throws InterruptedException {

        Thread tread = new Thread(() ->
                populateMap(map, machineReports.subList(0, machineReports.size() / 2)));

        Thread tread2 = new Thread(() ->
                populateMap(map, machineReports.subList(machineReports.size() / 2, machineReports.size())));

        tread.start();
        tread2.start();
        tread.join();
        tread2.join();
    }
}
