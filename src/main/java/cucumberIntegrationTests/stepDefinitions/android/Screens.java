package cucumberIntegrationTests.stepDefinitions.android;

import UITestFramework.CreateSession;
import cucumberIntegrationTests.screens.android.ScreenObjects;

public class Screens {
    ScreenObjects screenObjects;


    public Screens(CreateSession createSession) {
        screenObjects = new ScreenObjects(createSession.driver);
    }

}
