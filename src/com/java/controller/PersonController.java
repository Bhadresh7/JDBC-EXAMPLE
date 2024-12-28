package com.java.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.ConnectionUrl.Connections;
import com.java.entity.Person;
import com.java.queries.SqlQueries;
import com.java.repository.UserRepo;

public class PersonController  {

	Person person = new Person();
	Connections c = new Connections();

	private Connection con;

	public PersonController(Connection con) {
		this.con=con;
	}


	public void fetchUserData() {

		if(c.loadDriver()!=null) {
			System.out.println("driver loaded");

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SqlQueries.FETCH);
				while(rs.next()) {
					person.setUid(rs.getInt("uid"));
					person.setName(rs.getString("name"));
					person.setEmail(rs.getString("email"));
					person.setAddress(rs.getString("address"));
					person.setPassword(rs.getString("password"));
					System.out.println(person);
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}	else {
			System.out.println("Driver not loaded");
		}
	}


	public UserRepo repo = ()->{
		if(c.loadDriver()!=null) {
			System.out.println("driver loaded");

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SqlQueries.FETCH_ONLY_NAME);
				while(rs.next()) {
					person.setName(rs.getString("name"));
					System.out.println(person.getName());
				}
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
		}	else {
			System.out.println("Driver not loaded");
		}
	};


}
