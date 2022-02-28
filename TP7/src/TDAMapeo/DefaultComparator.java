package TDAMapeo;

import java.util.Comparator;

public class DefaultComparator<K> implements java.util.Comparator<K> {
	public int compare (K a , K b){
		return ((Comparable<K>)a).compareTo(b);
	}
}
