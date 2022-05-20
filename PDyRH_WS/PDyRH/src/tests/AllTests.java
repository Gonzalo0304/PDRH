package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContBDImpleBusqCasoTest.class, ContBDImpleBusqPerTest.class, ContBDImpleBusqRHTest.class,
		ContBDImpleBusqTest.class, ContBDImpleCompEspTest.class, ContBDImpleCompTest.class,
		ContBDImpleGestCasoTest.class, ContBDImpleGestPerTest.class, ContBDImpleInsertCasoTest.class,
		ContBDImpleInsertPerTest.class, ContBDImpleISTest.class, ContBDImpleRHTest.class })
public class AllTests {
}
