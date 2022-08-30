package ua.ithillel.homeworks.homework19.mapper;

import ua.ithillel.homeworks.homework19.model.MachineReport;
import ua.ithillel.homeworks.homework19.model.Status;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface ReportMapper<T> {

    List<T> readAll(Path path);

    void populateMap(Map<Status, List<MachineReport>> map, List<MachineReport> machineReports);

    void populateMapParallel(Map<Status, List<MachineReport>> map, List<MachineReport> machineReports)
            throws InterruptedException;
}
