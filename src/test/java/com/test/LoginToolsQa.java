package com.test;

import com.CommonFunctions;
import com.Constants;
import controllers.BaseMethod;
import listeners.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ExtentTestManager;

import java.lang.reflect.Method;
@Listeners(CustomListener.class)
public class LoginToolsQa extends CommonFunctions {
    @Test(description ="Login tools qa")
    public void Login(Method method) throws Exception
    {
        String description=method.getAnnotation(Test.class).description();
        ExtentTestManager.getTest().setDescription(description);
        ExtentTestManager.getTest().assignCategory(method.getAnnotation(Test.class).testName());
        launchWebsite();
        doLoginToolQa();
        validateSuccessfulLoginOfToolsQa();
    }

}
