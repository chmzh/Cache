package com.ref;

public class SoftCacheTest {
	public static void main(String[] args) {
		cache1();
	}
	
	public static void cache1(){
		SoftCache<Employee> cache = new SoftCache<Employee>();

		for(int i=0;i<10000000;i++) {
			cache.add(new Employee(i+""));
		} 
	}
}
