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

  def "call firestore service once when creating experiences data"() {
    given:
    final def experiences = TestUtils.mockExperiences()

    when:
    final def result = service.createData(experiences)

    then:
    1 * firestoreService.create("experiences", experiences.get(0)) >> "1"

    and:
    "ID: 1;" == result
  }

  def "call firestore service once when updating experiences data"() {
    given:
    final def experiences = TestUtils.mockExperiences()

    when:
    final def result = service.updateData(experiences)

    then:
    0 == result.size()
  }

}