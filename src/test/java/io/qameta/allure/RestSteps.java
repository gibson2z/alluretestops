package io.qameta.allure;

public class RestSteps {

    public void createIssueWithTitle(String owner, String repo, String title) {
        // Simulate creating an issue
        System.out.printf("Created issue in repo '%s/%s' with title: %s%n", owner, repo, title);
    }

    public void shouldSeeIssueWithTitle(String owner, String repo, String title) {
        // Simulate verification of issue presence
        System.out.printf("Verified issue in repo '%s/%s' has title: %s%n", owner, repo, title);
    }

    public void closeIssueWithTitle(String owner, String repo, String title) {
        // Simulate closing an issue
        System.out.printf("Closed issue in repo '%s/%s' with title: %s%n", owner, repo, title);
    }

    public void shouldRetrieveIssueWithTitle(String owner, String repo, String title) {
        // Simulate retrieving issue and asserting the title
        System.out.printf("Retrieved issue in repo '%s/%s' with expected title: %s%n", owner, repo, title);
    }

    public void updateIssueTitle(String owner, String repo, String oldTitle, String newTitle) {
        // Simulate updating an issue title
        System.out.printf("Updated issue title from '%s' to '%s' in repo '%s/%s'%n", oldTitle, newTitle, owner, repo);
    }

    public void shouldListAllIssues(String owner, String repo) {
        // Simulate listing all issues
        System.out.printf("Listed all issues for repo '%s/%s'%n", owner, repo);
    }
}
