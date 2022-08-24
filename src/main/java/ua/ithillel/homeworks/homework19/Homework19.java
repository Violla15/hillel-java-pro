package ua.ithillel.homeworks.homework19;

import ua.ithillel.homeworks.homework19.mapper.MachineReportMapper;
import ua.ithillel.homeworks.homework19.model.MachineReport;
import ua.ithillel.homeworks.homework19.model.Status;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework19 {
    public static final Path PATH = Paths.get("src/main/java/ua/ithillel/homeworks/homework19/machine-readable.csv");


    public static void main(String[] args) {

        System.out.println("Starting non-parallel execution ");
        executionTime();

        System.out.println("==========================");

        System.out.println("Starting parallel execution ");
        executionTimeParallel();

    }

    public static void message(MachineReportMapper mapper) {
        System.out.println("Status F : " + mapper.getListStatus_F().size() + " reports");
        System.out.println("Status R : " + mapper.getListStatus_R().size() + " reports");
        System.out.println("Status C : " + mapper.getListStatus_C().size() + " reports");
    }

    public static void executionTime() {
        MachineReportMapper mapper = new MachineReportMapper();
        Map<Status, List<MachineReport>> statusListMap = new HashMap<>();
        mapper.readAll(PATH);
        long startTime = Instant.now().toEpochMilli();
        mapper.populateMap(statusListMap, mapper.getMachineReports());
        long endTime = Instant.now().toEpochMilli();
        long timeElapsed = endTime - startTime;
        message(mapper);
        System.out.println("Execution time : " + timeElapsed + " ms");
    }

    public static void executionTimeParallel() {
        Map<Status, List<MachineReport>> statusListMap = new HashMap<>();
        MachineReportMapper mapper2 = new MachineReportMapper();
        mapper2.readAll(PATH);
        long start = Instant.now().toEpochMilli();
        try {
            mapper2.populateMapParallel(statusListMap, mapper2.getMachineReports());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = Instant.now().toEpochMilli();
        long timeElapsed = endTime - start;
        message(mapper2);
        System.out.println("Execution time : " + timeElapsed + " ms");
    }
}
