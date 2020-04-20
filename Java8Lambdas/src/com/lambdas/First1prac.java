package com.lambdas;

public class First1prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");

		// Without Lambda
		MyFirstLambda m1 = new MyFirstLambda(){
			@Override
			public void myrun() {
				System.out.println("My First Lambda");
			}
		};
		m1.myrun();
		
		// With Lambda
		MyFirstLambda myFirstLambda = () -> System.out.println("My First Lambda");
		myFirstLambda.myrun();
		
		
	}

}

interface MyFirstLambda{
	void myrun();
}