package com.java.Main;

import java.sql.Connection;

import com.java.ConnectionUrl.Connections;
import com.java.controller.PersonController;

public class MainClass {

	public static void main(String[] args) {

		Connections con = new Connections();
		Connection connect=con.loadDriver();

		PersonController controller = new PersonController(connect);
		controller.fetchUserData();

		controller.repo.getPersonNames();

		con.closeConnection();


	}
}
