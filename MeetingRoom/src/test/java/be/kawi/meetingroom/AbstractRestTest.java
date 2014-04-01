package be.kawi.meetingroom;

import be.kawi.meetingroom.util.ReflectionUtils;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;

public class AbstractRestTest extends JerseyTest {


    protected void injectMocks(Object controller, Object... mocks) {
        try {
            ReflectionUtils.injectDependencies(controller, mocks);
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        }
    }

}
