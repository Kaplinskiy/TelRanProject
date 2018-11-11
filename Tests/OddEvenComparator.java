

public class OddEvenComparator implements MyComparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		int tmp = (int)obj2 - (int)obj1;
		return  (tmp%2==0) ? tmp*(1-2*Math.abs((int)obj1%2)) : ((int)obj1%2 == 0) ? 1 : -1;
	}

}
