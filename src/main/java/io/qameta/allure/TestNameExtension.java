package io.qameta.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import static io.qameta.allure.Allure.getLifecycle;

public class TestNameExtension implements AfterEachCallback {
    
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // Get the display name from the test method
        String displayName = context.getDisplayName();
        
        // For parameterized tests, display name might include parameters
        // You can customize this to show only what you want
        String customName = extractCustomName(displayName);
        
        // Update the Allure test result name
        getLifecycle().updateTestCase(testResult -> {
            testResult.setName(customName);
        });
    }
    
    private String extractCustomName(String displayName) {
        // Remove parameter information if present
        // Example: "shouldUpdateUserNote(String, String) [1] First Note, Updated First Note"
        // becomes: "Update issue"
        
        if (displayName.contains("shouldUpdateUserNote")) {
            return "Update issue";
        }
        
        // Or use @DisplayName if available
        // For more sophisticated extraction, you can access annotations
        return displayName;
    }
}
