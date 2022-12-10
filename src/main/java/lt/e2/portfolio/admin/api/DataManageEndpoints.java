package lt.e2.portfolio.admin.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface DataManageEndpoints<T> {

    @GetMapping
    T getData();

    @PostMapping
    void createData(T data);

}
