package lt.e2.portfolio.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Basics implements FirebaseObject {

    private String name;
    private String middleName;
    private String surname;
    private String position;
    private String city;
    private String country;
    private String description;
    private String companyName;
    private String companyUrl;

}
