

public class StringsLengthComp implements MyComparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		
		return ((String)obj1).length()-((String)obj2).length();
	}

}
