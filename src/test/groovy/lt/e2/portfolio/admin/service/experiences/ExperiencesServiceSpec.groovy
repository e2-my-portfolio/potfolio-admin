package lt.e2.portfolio.admin.service.experiences

import lt.e2.portfolio.admin.TestUtils
import spock.lang.Subject;

import lt.e2.portfolio.admin.firebase.FirestoreService;
import lt.e2.portfolio.admin.model.Experience;
import spock.lang.Specification;

class ExperiencesServiceSpec extends Specification {

  private FirestoreService<Experience> firestoreService = Mock()

  @Subject
  private ExperiencesService service

  def "setup"() {
    service = new ExperiencesServiceImpl(firestoreService)
  }

  def "call firestore service when getting experiences data"() {
    given:
    final def experiences = TestUtils.mockExperiences()

    when:
    final def result = service.getData()

    then:
    1 * firestoreService.get("experiences", Experience.class) >> experiences

    and:
    experiences == result
  }

}