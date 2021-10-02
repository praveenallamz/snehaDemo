package com.test;

import com.CommonFunctions;
import listeners.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentTestManager;

import java.lang.reflect.Method;
@Listeners(CustomListener.class)
public class SearchBookToolQa extends CommonFunctions {

    @Test(description ="search book on tools qa")
    public void SearchBook(Method method) throws Exception
    {
        String description=method.getAnnotation(Test.class).description();
        ExtentTestManager.getTest().setDescription(description);
        ExtentTestManager.getTest().assignCategory(method.getAnnotation(Test.class).testName());
        launchWebsite();
        searchBookOnToolQa();
        validateBookSearchedOnToolsQa();
    }
}
