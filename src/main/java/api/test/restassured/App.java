package api.test.restassured;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestNG;

public class App {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        File f = new File("/workspace/crocodiles-restassured-tests/target/test-classes");
        URL[] cp = { f.toURI().toURL() };
        URLClassLoader urlcl = new URLClassLoader(cp);
        Class myclass = urlcl.loadClass("api.test.restassured.ListPublicCrocodilesTests");

        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { myclass });
        LocalReporter reporter = new LocalReporter();
        testng.addListener(reporter);
        testng.setVerbose(3);
        testng.run();
        System.out.println(myclass.getMethods()[0].getName());
        System.out.println(reporter.getAllOutputs().toString());

        // List<String> xmlFile = new ArrayList<String>();
        // xmlFile.add("/workspace/crocodiles-restassured-tests/testng.xml");
        // TestNG tng = new TestNG();
        // tng.setTestSuites(xmlFile);
        // tng.run();
    }

    public static class LocalReporter implements IReporter, IInvokedMethodListener {
        private List<String> allOutputs = new LinkedList<>();

        List<String> getAllOutputs() {
            return allOutputs;
        }

        @Override
        public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
            System.out.println("testMethod:" + method.getTestMethod().getMethodName());
            System.out.println("testResult:" + testResult.toString());
            allOutputs.addAll(Reporter.getOutput(testResult));
        }
    }
}
