package lt.e2.portfolio.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Stories implements FirebaseObject {

    @DocumentId
    @JsonIgnore
    private String id;

    private String title;

    private String content;

}
