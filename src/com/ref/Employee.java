package com.ref;

public class Employee implements Cacheable {

	private String id;

	private String name;
	private byte[] data;
	public Employee(String id) {

		this.id = id;

		this.name = String.valueOf(System.currentTimeMillis());
		this.data = new byte[1024*1024*10];
		// System.out.println("Employee.Employee() ..从数据库中或者其他资源获取对象");

	}

	public String getId() {

		return id;

	}

	public void setId(String id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	@Override
	public String getCacheKey() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
