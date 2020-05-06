import java.util.ArrayList;
import java.util.Collections;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author DANIEL AGUILAR
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;

		// TODO: initialize myWords
		for (int i = 0; i < size; i++) {
			myWords[i] = source[i+start];
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return the length of the string array
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * returns true when the object is in the wordgram and its strings are ordered the same, returns false otherwise
	 * @param o is being checked if it is a WordGram
	 * @return true if object is in WordGram and string order is equal, else returns false
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		// TODO: Complete this method
		WordGram wg = (WordGram) o;
		if (this.hashCode() != wg.hashCode()) {
			return false;
		}
		if (!this.toString().equals(wg.toString())){
			return false;
		}
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 0) {
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * Creates and returns new wordgram object with k entries
	 * whose first k-1 entries are the same as last k-1 entries
	 * last entry is last string in parameter
	 * @param last is last String of returned WordGram
	 * @return new wordgram whose first element is removed and last element is last parameter
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for (int k = 1; k < wg.myWords.length; k++) {
			wg.myWords[k-1] = wg.myWords[k];
		}
		wg.myWords[wg.length() - 1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		myToString = String.join(" ", myWords);
		return myToString;
	}
}
