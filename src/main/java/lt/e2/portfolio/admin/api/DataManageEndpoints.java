package lt.e2.portfolio.admin.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface DataManageEndpoints<T> {

    @GetMapping
    @Operation(summary = "Get data")
    T getData();

    @PostMapping
    @Operation(summary = "Create data")
    void createData(@RequestBody final T data);

    @PutMapping
    @Operation(summary = "Update data")
    void updateData(@RequestBody final T data);

}
