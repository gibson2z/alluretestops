package io.qameta.allure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Layer("web")
@Owner("eroshenkoam")
@Feature("Issues")
public class IssuesWebTest {

    private static final String OWNER = "allure-framework, not-allure-framework";
    private static final String REPO = "allure2";

    private static final String ISSUE_TITLE = "Some issue, title here";

    private final WebSteps steps = new WebSteps();

    @BeforeEach
    public void startDriver() {
        steps.startDriver();
    }

    @Test
    @TM4J("AE-T4")
    @Microservice("Repository")
    @Story("Create new issue")
    @Tags({@Tag("web"), @Tag("regress4")})
    @JiraIssues({@JiraIssue("AE-1")})
    @DisplayName("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInNjb3BlIjpbIm9wZW5pZCJdLCJpc3MiOiJBbGx1cmUgVGVzdE9wcyIsImV4cCI6MTcyODYxNjE0MiwiaWF0IjoxNzI4NTU4NTQyLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImNsaWVudF9pZCI6ImFsbHVyZS1nYXRld2F5LXNlcnZpY2UiLCJqdGkiOiI5MWM3NzA0Yy04MjI5dfghfghfgfghgfjtynvbnvvvjtj")
    public void shouldAddLabelToIssue() {
        steps.openIssuesPage(OWNER, REPO);
        steps.createIssueWithTitle(ISSUE_TITLE);
        steps.shouldSeeIssueWithTitle(ISSUE_TITLE);
    }

    @Test
    @TM4J("AE-T5")
    @Microservice("Repository")
    @Story("Close existing issue")
    @Tags({@Tag("web"), @Tag("regress4")})
    @JiraIssues({@JiraIssue("AE-1")})
    @DisplayName("Closing new issue for authorized user")
    public void shouldCloseIssue() {
        steps.openIssuesPage(OWNER, REPO);
        steps.createIssueWithTitle(ISSUE_TITLE);
        steps.closeIssueWithTitle(ISSUE_TITLE);
        steps.shouldNotSeeIssueWithTitle(ISSUE_TITLE);
    }

    @AfterEach
    public void stopDriver() {
        steps.stopDriver();
    }

}
