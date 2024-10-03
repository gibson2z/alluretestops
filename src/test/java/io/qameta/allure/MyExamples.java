package io.qameta.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@org.junit.jupiter.api.DisplayName("TTempTests.class unit tests")
    public class MyExamples {


    /**
     * Uses a basic '@Description' annotation and a javaDoc method that allows you to pass text commented out over the test
     * Pros: Very handy if you're used to keeping documentation in code.
     * Cons: The description is not strongly tied to the test, there is a chance to make a mistake.
     */

    @Test
    @DisplayName("Some test")
        @Description(useJavaDoc = true)
        public void test1667306661111() {
            step("some step name https://www");
            step("some step name www without https");
            step("* var serviceId1=\"temporaryRedirectWith www\"");
        step("step sleep 60", () -> {
//            Thread.sleep(60000);
            File file = new File("src/test/resources/321.txt");
            InputStream is = Files.newInputStream(file.toPath());
            addAttachment("123", is);
            step("sub step");
        });
        step(" temporaryRedirectWith www\n ");
        }

    @Test
    @DisplayName("new test")
    @Owner("daniil@qameta.io")
    @Feature("Issues")
    void testFromTestops() {
        step("step 1");
        step("step 2");
        step("step 3", () -> {
            step("sub step");
        });
        step("step sleep 60", () -> {
            Thread.sleep(60000);
            step("sub step");
        });

    }

    @Attachment(value = "Annotated attachment [{type}]", type = "text/plain", fileExtension = ".txt")
    public byte[] textAttachment(String type, String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }


}