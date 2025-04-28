package io.qameta.allure;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@Layer("rest")
@Owner("baev")
@Feature("Issues")
public class TestWithSteps {

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
    public void shouldCreateUserNote(@Param(value = "Title") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T2")
    @Story("Close existing issue")
    @Microservice("Repository")
    @Tags({@Tag("web"), @Tag("regress4")})
    @JiraIssues({@JiraIssue("AE-1")})
    @ParameterizedTest(name = "Close issue via api")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldDeleteUserNote(@Param(value = "Title") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.closeIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T3")
    @Story("Retrieve existing issue")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("regress4")})
    @Description("Verify retrieval of existing issue")
    @ParameterizedTest(name = "Retrieve issue with title {0}")
    @ValueSource(strings = {"First Note", "Second Note"})
    public void shouldRetrieveUserNote(@Param(value = "Title") String title) {
        steps.createIssueWithTitle(OWNER, REPO, title);
        steps.shouldRetrieveIssueWithTitle(OWNER, REPO, title);
    }

    @TM4J("AE-T4")
    @Story("Update existing issue")
    @Microservice("Repository")
    @Tags({@Tag("api"), @Tag("regress4")})
    @Description("Verify updating of an existing issue")
    @ParameterizedTest(name = "Update issue from {0} to {1}")
    @MethodSource("provideTitleUpdateData")
    public void shouldUpdateUserNote(@Param(value = "Old Title") String oldTitle, @Param(value = "New Title") String newTitle) {
        steps.createIssueWithTitle(OWNER, REPO, oldTitle);
        steps.updateIssueTitle(OWNER, REPO, oldTitle, newTitle);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, newTitle);
    }

    private static Stream<Arguments> provideTitleUpdateData() {
        return Stream.of(
            Arguments.of("First Note", "Updated First Note"),
            Arguments.of("Second Note", "Updated Second Note")
        );
    }

    @TM4J("AE-T5")
    @Story("List all issues")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("regress4")})
    @Description("Verify that all issues can be listed")
    @ParameterizedTest(name = "List all issues")
    public void shouldListAllUserNotes() {
        steps.createIssueWithTitle(OWNER, REPO, "First Note");
        steps.createIssueWithTitle(OWNER, REPO, "Second Note");
        steps.shouldListAllIssues(OWNER, REPO);
    }

    // New test scenarios with 100 character long names
    @TM4J("AE-T6")
    @Story("Create new issue with extremely long title to check system's handling of long inputs")
    @Microservice("Billing")
    @Tags({@Tag("api"), @Tag("regress4")})
    @Description("Test creating an issue with a long title")
    @ParameterizedTest(name = "Create issue via api with long title {0}")
    @ValueSource(strings = {"This is an extremely long title that exceeds the usual length limitations of the input field"})
    public void shouldCreateLongTitleUserNote(@Param(value = "Long Title") String longTitle) {
        steps.createIssueWithTitle(OWNER, REPO, longTitle);
        steps.shouldSeeIssueWithTitle(OWNER, REPO, longTitle);
    }

    @TM4J("AE-T7")
    @Story("Close existing issue with extremely long title to check system's handling of long inputs")
    @Microservice("Repository")
    @Tags({@Tag("api"), @Tag("regress4")})
    @JiraIssues({@JiraIssue("AE-2")})
    @ParameterizedTest(name = "Close issue via api with long title {0}")
    @ValueSource(strings = {"This is an extremely long title that exceeds the usual length limitations of the input field"})
    public void shouldDeleteLongTitleUserNote(@Param(value = "Long Title") String longTitle) {
        steps.createIssueWithTitle(OWNER, REPO, longTitle);
        steps.closeIssueWithTitle(OWNER, REPO, longTitle);
    }
}
