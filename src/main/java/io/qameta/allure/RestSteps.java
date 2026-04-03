package io.qameta.allure;

import io.qameta.allure.Step;

import static io.qameta.allure.Allure.step;

public class RestSteps {

    @Step("Create issue with title `{title}`")
    public void createIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("POST /repos/%s/%s/issues", owner, repo));
    }

    @Step("Close issue with title `{title}`")
    public void closeIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?text=%s", owner, repo, title));
        step(String.format("PATCH /repos/%s/%s/issues/%s", owner, repo, 10));
    }

    @Step("Check note with content `{title}` exists")
    public void shouldSeeIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?text=%s", owner, repo, title));
        step(String.format("GET /repos/%s/%s/issues/%s", owner, repo, 10));
    }

    // ADD THESE THREE MISSING METHODS:

    @Step("Retrieve issue with title `{title}`")
    public void shouldRetrieveIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?title=%s", owner, repo, title));
        // Add assertions here to verify the issue was retrieved correctly
    }

    @Step("Update issue title from `{oldTitle}` to `{newTitle}`")
    public void updateIssueTitle(final String owner, final String repo, final String oldTitle, final String newTitle) {
        step(String.format("GET /repos/%s/%s/issues?title=%s", owner, repo, oldTitle));
        step(String.format("PATCH /repos/%s/%s/issues/%s", owner, repo, 10));
        step(String.format("Title updated from '%s' to '%s'", oldTitle, newTitle));
        // Add logic to find the issue ID and update it
    }

    @Step("List all issues in repository")
    public void shouldListAllIssues(final String owner, final String repo) {
        step(String.format("GET /repos/%s/%s/issues", owner, repo));
        step("Verify that all issues are listed correctly");
        // Add assertions to verify the list of issues
    }
}
