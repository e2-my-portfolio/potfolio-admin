package lt.e2.portfolio.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Experience implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;
    private Company company;
    private String position;
    private List<Project> projects;
    private String stack;
    private String startDate;
    private String endDate;

}
