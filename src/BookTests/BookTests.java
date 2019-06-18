package BookTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({addHoldRequrestTest.class,BookisAvailableTest.class,getAuthorTest.class,getBookIDTest.class,
	getCurrentBorrowerTest.class,getCurrentIdNumberTest.class,getGenreTest.class,getPublisherTest.class,getPublishingDateTest.class,getTitleTest.class})
public class BookTests {

}
