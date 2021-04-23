package testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;

@RunWith(Suite.class)
@SuiteClasses({
	   HRTC2.class,
	   HRTC3.class,
	   HRTC4.class
})

public class TestSuite
{
 /* empty class */
}

