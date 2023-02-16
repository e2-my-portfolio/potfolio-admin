package lt.e2.portfolio.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Skill implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;

    @NotNull
    private String name;

    @NotNull
    @Min(value = 1, message = "Lowest skills level could be 1")
    @Max(value = 7, message = "Highest skills level could be 7")
    private int level;

}
