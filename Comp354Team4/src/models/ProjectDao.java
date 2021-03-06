package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.*;
import controllers.ConverterService;

public class ProjectDao {

	private static String SelectProjectsGivenManagerId = "SELECT * FROM Project WHERE managerId = @userId AND isRemoved = 0";
	private static String InsertProjects = "INSERT INTO Project(projectName, startDate, endDate, managerId) VALUES ('@projectName', '@startDate', '@endDate', '@managerId');";
	public static String CreateTable = "CREATE TABLE Project (id INTEGER PRIMARY KEY, projectName varchar(50),	"
			+ "startDate DateTime, endDate DateTime, managerId INTEGER, FOREIGN KEY(managerId) REFERENCES User(id));";

	public static String DeleteProjectGivenProjectId = "UPDATE Project SET isRemoved = '1' WHERE id = @id";
	public static String UpdateProjectGivenProjectId = "UPDATE Project SET projectName = '@projectName', startDate = '@startDate', endDate = '@endDate' WHERE id = @id ";

	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public String[] GetProjectColumns() {
		String[] columns = { "Project Id", "Project Name", "Start Date", "End Date", "Manager Id", " ", " ", " " };

		return columns;
	}

	public String[] returnDataRow(Project project) {
		String[] temp = new String[] { Integer.toString(project.getId()), project.getProjectName(),
				ConverterService.DateToString(project.getStartDate()),
				ConverterService.DateToString(project.getEndDate()), Integer.toString(project.getManagerId()),
				"View Activities", "Edit", "Delete" };
		return temp;
	}

	// get a list of project ids managed by user id
	// returns null if there's no projects found
	public List<Project> GetProjectsGivenManagerId(int userId) {
		List<Project> projects = new ArrayList<Project>();

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName(SqliteSetup.sqliteClass);
			c = DriverManager.getConnection(SqliteSetup.connection);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			String sql = ProjectDao.SelectProjectsGivenManagerId.replace("@userId", Integer.toString(userId)); // prepare
																												// sql

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Project temp = null;
				temp = ProjectDao.mapResultSetToProject(rs);
				projects.add(temp);
			}

			rs.close();
			stmt.close();
			c.close();

		}

		catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Operation done successfully");

		return projects;
	}

	// insert project into database
	public boolean InsertProject(Project project) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName(SqliteSetup.sqliteClass);
			c = DriverManager.getConnection(SqliteSetup.connection);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();

			String sql = ProjectDao.InsertProjects.replace("@projectName", project.getProjectName())
					.replace("@startDate", ConverterService.DateToString(project.getStartDate())). // format date to string
					replace("@endDate", ConverterService.DateToString(project.getEndDate())). // format date to string
					replace("@managerId", Integer.toString(project.getManagerId()));
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			System.out.println("Sql Executed Successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean DeleteProject(int id) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName(SqliteSetup.sqliteClass);
			c = DriverManager.getConnection(SqliteSetup.connection);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			String sql = ProjectDao.DeleteProjectGivenProjectId.replace("@id", Integer.toString(id));
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			System.out.println("Sql Executed Successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean UpdateProject(Project project) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName(SqliteSetup.sqliteClass);
			c = DriverManager.getConnection(SqliteSetup.connection);
			System.out.println("Opened database successfully: updateProject ");
			stmt = c.createStatement();
			String sql = ProjectDao.UpdateProjectGivenProjectId.replace("@projectName", project.getProjectName())
					.replace("@startDate", ConverterService.DateToString(project.getStartDate())). // format
																									// date
																									// to
																									// string
					replace("@endDate", ConverterService.DateToString(project.getEndDate())). // format
																								// date
																								// to
																								// string
					replace("@id", Integer.toString(project.getId()));
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			System.out.println("Sql Executed Successfully: updateProject");

			// replace("@projectName", project.getProjectName()).
			// replace("@startDate",
			// ConverterService.DateToString(project.getStartDate())). //format
			// date to string
			// replace("@endDate",
			// ConverterService.DateToString(project.getEndDate())). //format
			// date to string
			// replace("@managerId", Integer.toString(project.getManagerId()));
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return false;
		}
		return true;
	}

	// map resultset from sqlite to User entity
	public static Project mapResultSetToProject(ResultSet rs) {
		Project temp = null; 

		try {
			temp = new Project(rs.getInt("id"), rs.getString("projectName"), rs.getString("startDate"),
					rs.getString("endDate"), rs.getInt("managerId"));
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return temp;
	}
}
