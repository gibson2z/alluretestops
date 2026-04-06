import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.qameta.allure.Allure.getLifecycle;

public class TestNameExtension implements AfterEachCallback {
    
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        getLifecycle().updateTestCase(testResult -> 
            testResult.setName(context.getDisplayName())
        );
    }
}
