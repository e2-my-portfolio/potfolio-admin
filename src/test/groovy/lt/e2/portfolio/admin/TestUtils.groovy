package lt.e2.portfolio.admin

import lt.e2.portfolio.admin.model.Basics
import lt.e2.portfolio.admin.model.Company
import lt.e2.portfolio.admin.model.Experience
import lt.e2.portfolio.admin.model.Project
import lt.e2.portfolio.admin.model.Skill
import lt.e2.portfolio.admin.model.SkillsGroup
import lt.e2.portfolio.admin.model.Stories
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.web.multipart.MultipartFile

import static lt.e2.portfolio.admin.TestConstants.*

class TestUtils {

    static Basics mockBasics() {
        new Basics(
                NAME,
                MIDDLE_NAME,
                SURNAME,
                POSITION,
                CITY,
                COUNTRY,
                DESCRIPTION,
                COMPANY_NAME,
                COMPANY_URL)
    }

    static List<Experience> mockExperiences() {
        final def company = new Company(COMPANY_NAME, COUNTRY)
        final def project = new Project("Project", "My project")
        List.of(Experience.builder()
                .company(company)
                .position(POSITION)
                .projects(List.of(project))
                .stack("")
                .startDate("2023-01")
                .build()
        )
    }

    static MultipartFile mockFile() {
        new MockMultipartFile(
                "file",
                "file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                InputStream.nullInputStream()
        )
    }

    static List<SkillsGroup> mockSkills() {
        final def skill1 = Skill.builder()
                .name("Skill 1")
                .level(5)
                .build()
        final def skill2 = Skill.builder()
                .name("Skill 2")
                .level(1)
                .build()
        List.of(
                new SkillsGroup(null,
                        "Skills Group",
                        null,
                        List.of(skill1, skill2))
        )
    }

    static List<Stories> mockStories() {
        List.of(
                new Stories("id1", "Story 1", "My story 1"),
                new Stories("id1", "Story 2", "My story 2")
        )
    }

}
