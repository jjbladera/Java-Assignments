/*
--------------------------------------------------------------------------------
Author   : Javier C, jchavez589@cnm.edu
Course   : CIS2235, Java Programming I
Project  : Program 8: DataBase Manipulation
Document : DbManager.java
--------------------------------------------------------------------------------
*/
package data;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * TODO
 * chnage method names
 *  
 */
public class DbManager {

	//Add to beginning of MS Access DB URL
	private final String ACCESS_DB_URL_PREFIX =
		"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
	//Add to end of MS Access DB URL
	private final String ACCESS_DB_URL_SUFFIX = ";DriverID=22;READONLY=false;}";
	//File name of database
	private final String MY_DB_NAME = "WebsiteDatabase.mdb";

	private String fileName;
	private Connection myConnection;

	//constructor
	public DbManager() {
		try {
			myConnection = getAccessDbConnection(MY_DB_NAME);
			myConnection.setAutoCommit(true);
			DatabaseMetaData md = myConnection.getMetaData();
		} catch (SQLException ex) {
			Logger.getLogger
			            (DbManager.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(null,
				"The database could not be located. Please select the database"
				+ " file you wish to connect to.",
				"Database Error", JOptionPane.ERROR_MESSAGE);
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(chooser);
			fileName = chooser.getSelectedFile().toString();
			try {
				myConnection = getAccessDbConnection(fileName);
				myConnection.setAutoCommit(true);
				DatabaseMetaData md = myConnection.getMetaData();
			} catch (SQLException ex1) {
				Logger.getLogger
				       (DbManager.class.getName()).log(Level.SEVERE, null, ex1);
				JOptionPane.showMessageDialog(null,
					"The database could not be opened", "Fatal Error",
					JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	//"destructor" method to release the database connection
	public void close() {
		try {
			myConnection.close();
		} catch (SQLException ex) {
			Logger.getLogger
			            (DbManager.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	//public methods to access the database
	public void insert(Website w) throws SQLException {
		String sql;
		//build SQL statement
		sql = "INSERT INTO Websites";
		sql += " (COMPANY_NAME, COMP_ASSETS, YR_FOUNDED, URL_ADD, ALEXA_RANK)";
		sql += " VALUES (";
		sql += "'" + w.getCompName() + "',";
		sql += w.getAssets() + ",";
		sql += " #" +w.getFounded() + "#,";
		sql += " '" + w.getUrl() + "',";
		sql += w.getAlexaRank() + ");";
                insertRecord(sql);
	}
	public void update(Website w) throws SQLException {
		String sql;
                //SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                //date.parse(w.getFounded());
//                "#"
		//build SQL statement
		sql = "UPDATE WebsiteS SET";
		sql += " COMPANY_NAME = '" + w.getCompName() + "',";
		sql += " COMP_ASSETS = " + w.getAssets() + ",";
		sql += " YR_FOUNDED = #" + w.getFounded() + "#,";
		sql += " URL_ADD = '" + w.getUrl() + "',";
                sql += " ALEXA_RANK = " + w.getAlexaRank() ;

		sql += " WHERE ID = " + w.getId() + ";";
		updateRecord(sql);
	}
	public void delete(Website w) throws SQLException {
		String sql;
		sql = "DELETE * FROM Websites WHERE ID = " + w.getId() + ";";
		deleteRecord(sql);
	}
	public String[] getWebsiteList() throws SQLException {
		String strSql = "SELECT COMPANY_NAME FROM Websites;";
		PreparedStatement ps = myConnection.prepareStatement(strSql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = ps.executeQuery();

		rs.last();
		int rowCount = rs.getRow();
		String[] items = new String[rowCount];

		try {
			rs.beforeFirst();
			int i = 0;
			while(rs.next()) {
				items[i] = rs.getString("COMPANY_NAME");
				i++;
			}
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null,
				"getWebsiteList: Unable to read website names: " + ex.getMessage());
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getLocalizedMessage());
		}

		return items;
	}
	public int[] getWebsiteIds() throws SQLException {
		int[] id;
		String strSql = "SELECT ID FROM Websites;";
		PreparedStatement ps = myConnection.prepareStatement(strSql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = ps.executeQuery();

		rs.last();
		int rowCount = rs.getRow();
		id = new int[rowCount];

		try {
			rs.beforeFirst();
			int i = 0;
			while(rs.next()) {
				id[i] = rs.getInt("ID");
				i++;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
				"getWebsiteIDs: Unable to read Website IDs: " + ex.getMessage());
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getLocalizedMessage());
		}

		return id;
	}
	public Website getWebsite(int wId) throws SQLException {
		String[] rec;
		String strSql = "SELECT * FROM Websites WHERE ID = " + wId + ";";
		Website website = null;
		PreparedStatement ps = myConnection.prepareStatement(strSql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsMeta = rs.getMetaData();
		int columns = rsMeta.getColumnCount();
		rec = new String[columns];
		try {
			rs.beforeFirst();
			while(rs.next()) {
				for (int i = 0; i < columns; i++) {
					rec[i] = rs.getString(i + 1);
				}
			}

			//use the data to build the Website object
			website = new Website(
				//Integer.parseInt(rec[0]),
				rec[0],
				rec[1],
				rec[2],
				rec[3],
                                rec[4],
                                rec[5]
			);
		} catch (SQLException ex) {
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getLocalizedMessage());
		}
		return website;
	}

	//private method to establish database connection
	private Connection getAccessDbConnection(String fileName)
		                                                   throws SQLException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException ex) {
			System.err.println("JdbcOdbc Bridge Driver not Found");
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Driver Error",
				JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		String databaseURL = ACCESS_DB_URL_PREFIX + fileName
			                                             + ACCESS_DB_URL_SUFFIX;
		return DriverManager.getConnection(databaseURL);
	}

	//private methods to access the database
	private void insertRecord(String strSql) throws SQLException {
		Statement st = myConnection.createStatement();
		try {
			st.execute(strSql);
		} catch (SQLException ex) {
			System.err.println(ex.getStackTrace());
			System.err.println(ex.getMessage());
			System.err.println(ex.getLocalizedMessage());
		}
		st.close();
	}
	private void updateRecord(String strSql) throws SQLException {
		//use prepared statement to ensure that the result set is editable
		PreparedStatement ps = myConnection.prepareStatement(strSql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		try {
			ps.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getStackTrace());
			System.err.println(ex.getMessage());
			System.err.println(ex.getLocalizedMessage());
		}
	}
	private void deleteRecord(String strSql) throws SQLException {
		PreparedStatement ps = myConnection.prepareStatement(strSql,
			ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		try {
			ps.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getStackTrace());
			System.err.println(ex.getMessage());
			System.err.println(ex.getLocalizedMessage());
		}
	}
}
