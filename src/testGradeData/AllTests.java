package testGradeData;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEvalRanks.class, TestGetStudentById.class, TestLoadInput.class, TestUpdateWeightedGrades.class })
public class AllTests {

}
