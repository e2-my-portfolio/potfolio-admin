package lt.e2.portfolio.admin.api.skills

import lt.e2.portfolio.admin.TestUtils
import lt.e2.portfolio.admin.service.skills.SkillsService
import spock.lang.Specification
import spock.lang.Subject

class SkillsControllerSpec extends Specification {

    private SkillsService skillsService = Mock()

    @Subject
    private SkillsEndpoints controller

    def "setup"() {
        controller = new SkillsController(skillsService)
    }

    def "get skills data"() {
        given:
        final def mock = TestUtils.mockSkills()

        when:
        final def result = controller.getData()

        then:
        1 * skillsService.getData() >> mock

        and:
        mock == result
    }

    def "create skills data"() {
        given:
        final def request = TestUtils.mockSkills()

        when:
        final def result = controller.createData(request)

        then:
        1 * skillsService.createData(request) >> "1"

        and:
        result === "1"
    }

    def "update skills data"() {
        given:
        final def request = TestUtils.mockSkills()

        when:
        final def response = controller.updateData(request)

        then:
        1 * skillsService.updateData(request) >> Collections.emptyList()

        and:
        response == Collections.emptyList()
    }

}
