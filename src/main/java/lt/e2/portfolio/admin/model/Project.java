package lt.e2.portfolio.admin.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Project implements FirebaseObject {

    private String name;
    private String description;

}
