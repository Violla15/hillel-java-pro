package ua.ithillel.homeworks.homework19;

import ua.ithillel.homeworks.homework19.mapper.MachineReportMapper;
import ua.ithillel.homeworks.homework19.model.MachineReport;
import ua.ithillel.homeworks.homework19.model.Status;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework19 {
    public static Path myPath = Paths.get("src/main/java/ua/ithillel/homeworks/homework19/machine-readable.csv");
    public static List<MachineReport> machineReports = new ArrayList<>();
    public static Map<Status, List<MachineReport>> statusListMap = new HashMap<>();
    public static List<MachineReport> listStatus_R = new ArrayList<>();
    public static List<MachineReport> listStatus_F = new ArrayList<>();
    public static List<MachineReport> listStatus_C = new ArrayList<>();


    public static void main(String[] args) {

        MachineReportMapper machineReportMapper = new MachineReportMapper();
        machineReportMapper.readAll(myPath);
        System.out.println("Starting non-parallel execution ");
        executionTimeNon_parallel();
        System.out.println("==========================");
        System.out.println("Starting parallel execution ");
        executionTimeParallel();

    }
    public static void message() {
        System.out.println("Status F : " + listStatus_F.size() + " reports");
        System.out.println("Status R : " + listStatus_R.size() + " reports");
        System.out.println("Status C : " + listStatus_C.size() + " reports");
        listStatus_C.clear();
        listStatus_F.clear();
        listStatus_R.clear();
    }

    public static void executionTimeNon_parallel() {
        long startTime = Instant.now().toEpochMilli();

        MachineReportMapper mapper = new MachineReportMapper();
        mapper.populateMap(statusListMap, machineReports);
        long endTime = Instant.now().toEpochMilli();
        message();
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time : " + timeElapsed + " ms");
    }

    public static void executionTimeParallel() {
        long start = Instant.now().toEpochMilli();
        MachineReportMapper mapper = new MachineReportMapper();
        try {
            mapper.populateMapParallel(statusListMap, machineReports);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = Instant.now().toEpochMilli();
        long timeElapsed = endTime - start;
        message();
        System.out.println("Execution time : " + timeElapsed + " ms");
    }
}
