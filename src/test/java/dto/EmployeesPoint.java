package dto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class EmployeesPoint {

    public record EmployeePoint(String keyDate, int sumEmployees) {}

    private final List<EmployeePoint> data;
    private final List<String> dates;
    private final List<Integer> empSum;

    public EmployeesPoint() {
        try {
            this.data =
                    Files.lines(Path.of("src/test/resources/Employees.csv"), UTF_8)
                            .skip(1)
                            .map(line -> line.split(";"))
                            .map(arr -> new EmployeePoint(
                                    arr[0].trim(),
                                    Integer.parseInt(arr[1].trim())))
                            .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.dates  = data.stream().map(EmployeePoint::keyDate).toList();
        this.empSum = data.stream().map(EmployeePoint::sumEmployees).toList();
    }

    public List<String> getDates()         { return dates; }
    public List<Integer> getEmpSum()       { return empSum; }


}
