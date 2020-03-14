package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;

public class Main {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
Heap<String> a = new Heap();

Collection<String> collection = new ArrayList<String>();

	collection.add("zero");
	collection.add("one");
	collection.add("two");

	a.build(collection);

    
	}

}
