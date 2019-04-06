package testStudent;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testCompareTo.class, TestEquals.class, TestEvalWeightedGrade.class })
public class AllTests {

}
