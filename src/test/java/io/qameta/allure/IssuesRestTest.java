package io.qameta.allure;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Layer("rest")
@Owner("baev")
@Feature("Issues")
public class IssuesRestTest {

    private static final String OWNER = "allure-framework, not-allure-framework";
    private static final String REPO = "allure2";

    private final RestSteps steps = new RestSteps();

    @TM4J("AE-T1")
    @Story("Create new issue")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("smoke4")})
    @Description("description from test result")
    @ParameterizedTest(name = "Create issue via api {0}")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldCreateUserNote(@Param(value = "Title,") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T2")
    @Story("Close existing issue")
    @Microservice("Repository")
    @Tags({@Tag("web"), @Tag("regress4")})
    @JiraIssues({@JiraIssue("AE-1")})
    @ParameterizedTest(name = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInNjb3BlIjpbIm9wZW5pZCJdLCJpc3MiOiJBbGx1cmUgVGVzdE9wcyIsImV4cCI6MTcyODYxNjE0MiwiaWF0IjoxNzI4NTU4NTQyLCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl0sImNsaWVudF9pZCI6ImFsbHVyZS1nYXRld2F5LXNlcnZpY2UiLCJqdGkiOiI5MWM3NzA0Yy04MjI5dfghfghfgfghgfjtynvbnvvvjtj")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldDeleteUserNote(@Param(value = "Title") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.closeIssueWithTitle(OWNER, REPO, title);
    }


}
