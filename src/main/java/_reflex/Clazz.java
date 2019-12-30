package _reflex;

import java.util.Stack;

public class Clazz {
	
	
	public Class<Clazz> getClassByName() {
		Stack test =new Stack();
		return Clazz.class;
	}

	@SuppressWarnings("unchecked")
	public Class<Clazz> getClassByUrl() throws ClassNotFoundException {
		String url = "_reflex.Clazz";
		return (Class<Clazz>) Class.forName(url);
	}
}
