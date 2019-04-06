package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CirkelTest.class, DriehoekTest.class, HangManTest.class, HintLetterTest.class, HintWoordTest.class,
                LijnStukTest.class, OmhullendeTest.class, PuntTest.class, RechthoekTest.class, SpelerTest.class, TekeningTest.class,
                WoordenLijstTest.class})
public class AllTests {

}
