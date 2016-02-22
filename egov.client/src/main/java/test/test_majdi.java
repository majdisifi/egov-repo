package test;

import delegate.UserDelegate;

public class test_majdi {
	public static void main(String[] args) {
		
		
		
		String pwd=UserDelegate.getProxy().findpwd("majdi.sifi@esprit.tn");
		System.out.println( pwd);
		
		
		
	}
}