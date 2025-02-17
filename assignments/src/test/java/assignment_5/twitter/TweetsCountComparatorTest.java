package assignment_5.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TweetsCountComparatorTest {

	private TwitterAccount mostTweet;
	private TwitterAccount lessTweet1;
	private TwitterAccount lessTweet2;
	private TweetsCountComparator comparator;

	@BeforeEach
	public void SetUp() {
		mostTweet = new TwitterAccount("aaron");
		lessTweet1 = new TwitterAccount("ben");
		lessTweet2 = new TwitterAccount("charlie");
		comparator = new TweetsCountComparator();
	}

	@Test
	@DisplayName("Sjekk sammenlikning basert på tweets")
	public void testCompare() {
		mostTweet.tweet("Tweet");
		mostTweet.tweet("Tweet");
		lessTweet1.tweet("Tweet");
		lessTweet2.tweet("Tweet");
		assertTrue(comparator.compare(mostTweet, lessTweet1) < 0,
				"Kontoen med flest tweets skulle komme først");
		assertTrue(comparator.compare(lessTweet1, mostTweet) > 0,
				"Kontoen med færrest tweets skulle komme sist");
		assertEquals(0, comparator.compare(lessTweet1, lessTweet2),
				"To kontoer med like mange tweets skal være like");
	}
}
