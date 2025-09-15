package tests;

import com.microsoft.playwright.Page;
import data.Constants;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import runners.BaseTest;
import steps.HomeSteps;

import java.io.File;

public class ChatbotInteractionTest extends BaseTest {
    HomeSteps homeSteps;

    @BeforeClass
    public void stepsInit() {
        homeSteps = new HomeSteps(page);
    }
    @Test
    public void chatbotInteractionAndUploadTest() {
        File file = new File(Constants.FILE_LOCATION);
        homeSteps
                .openHomePage()
                .rejectCookies()
                .openQuickAction()
                .openChatBot()
                .sendMessageToChatbot(Constants.CHATBOT_MESSAGE)
                .uploadingFile(file)
                .closeChatbot();
    }
}
