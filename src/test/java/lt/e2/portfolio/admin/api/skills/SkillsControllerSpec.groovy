package lt.e2.portfolio.admin.api.skills

import lt.e2.portfolio.admin.model.Skill
import lt.e2.portfolio.admin.model.SkillsGroup
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
        final def mock = mockSkillsData()

        when:
        final def result = controller.getData()

        then:
        1 * skillsService.getData() >> mock

        and:
        mock == result
    }

    def "create skills data"() {
        given:
        final def request = mockSkillsData()

        when:
        final def result = controller.createData(request)

        then:
        1 * skillsService.createData(request) >> "1"

        and:
        result === "1"
    }

    def "update skills data"() {
        given:
        final def request = mockSkillsData()

        when:
        final def response = controller.updateData(request)

        then:
        1 * skillsService.updateData(request) >> Collections.emptyList()

        and:
        response == Collections.emptyList()
    }

    private List<SkillsGroup> mockSkillsData() {
        final var skill1 = Skill.builder()
            .name("Skill 1")
            .level(5)
            .build()
        final var skill2 = Skill.builder()
                .name("Skill 2")
                .level(1)
                .build()
        return List.of(
                new SkillsGroup(null,
                        "Skills Group",
                        null,
                        List.of(skill1, skill2))
        )
    }
}
