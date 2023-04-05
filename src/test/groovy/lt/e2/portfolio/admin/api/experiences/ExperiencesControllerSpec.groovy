package lt.e2.portfolio.admin.api.experiences

import lt.e2.portfolio.admin.TestUtils
import lt.e2.portfolio.admin.service.experiences.ExperiencesService
import spock.lang.Specification
import spock.lang.Subject

class ExperiencesControllerSpec extends Specification {

    private ExperiencesService experiencesService = Mock()

    @Subject
    private ExperiencesEndpoints controller

    def "setup"() {
        controller = new ExperiencesController(experiencesService)
    }

    def "get experiences data"() {
        given:
        final def mock = TestUtils.mockExperiences()

        when:
        final def result = controller.getData()

        then:
        1 * experiencesService.getData() >> mock

        and:
        mock == result
    }

    def "create experiences data"() {
        given:
        final def request = TestUtils.mockExperiences()

        when:
        final def result = controller.createData(request)

        then:
        1 * experiencesService.createData(request) >> "1"

        and:
        "1" == result
    }

    def "update experience data"() {
        given:
        final def request = TestUtils.mockExperiences()

        when:
        final def response = controller.updateData(request)

        then:
        1 * experiencesService.updateData(request) >> Collections.emptyList()

        and:
        response == Collections.emptyList()
    }

}
