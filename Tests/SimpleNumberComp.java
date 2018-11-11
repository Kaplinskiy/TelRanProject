

public class SimpleNumberComp implements MyComparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		
		return (int)obj1-(int)obj2;
	}

}
