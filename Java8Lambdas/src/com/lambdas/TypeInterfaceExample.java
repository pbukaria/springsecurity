package com.lambdas;

public class TypeInterfaceExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringLength mylambda= t-> t.length();
		System.out.println(mylambda.getLength("Hello Lembda"));

	}
	
}

interface StringLength{
	int getLength(String s);
}