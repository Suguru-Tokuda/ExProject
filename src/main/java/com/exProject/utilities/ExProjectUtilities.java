package com.exProject.utilities;

import java.util.ArrayList;
import java.util.Collection;

public class ExProjectUtilities {
	
	public static <T> Collection<T> iterableToCollection(Iterable<T> iterable) {
		Collection<T> collection = new ArrayList<T>();
		for (T t : iterable)
			collection.add(t);
		return collection;
	}

}
