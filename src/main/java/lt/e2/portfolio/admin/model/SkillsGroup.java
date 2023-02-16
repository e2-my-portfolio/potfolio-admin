package lt.e2.portfolio.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SkillsGroup implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;

    @NotNull
    private String name;

    @Null
    private Integer order;

    @NotNull
    private List<Skill> skills;

}
