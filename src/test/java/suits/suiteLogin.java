package suits;

import loginTests.Negative1stLogin;
import loginTests.Positive1stLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by User on 04.03.2018.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({Negative1stLogin.class, Positive1stLogin.class} )

public class suiteLogin {
}
