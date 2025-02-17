package assignment_5.debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private boolean turnSwitch = true;
	private final Iterator<String> first;
	private final Iterator<String> second;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean hasNext() {
		return this.first.hasNext() || this.second.hasNext();
	}

	@Override
	public String next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}

		String result = null;

		if (!this.first.hasNext()) {
			//OLD CODE: result = this.first.next();
			result = this.second.next();
			//change to this.second.next(), so that it doesn't try to get next element of an iterator we already know has no next
		} else if (!this.second.hasNext()) {
			//OLD CODE: result = this.second.next();
			result = this.first.next();
			//same as with line 32
		} else {
			if (this.turnSwitch) {
				result = this.first.next();
				this.turnSwitch = false;
			} else if (!this.turnSwitch) {
				//change this from an if to an else if, since the previous line would set turnswitch to false, making the condition true and running the code in both ifs
				result = this.second.next();
				this.turnSwitch = true;
			}
		}

		return result;
	}
}
