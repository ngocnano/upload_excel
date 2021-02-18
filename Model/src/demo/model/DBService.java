package demo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class DBService {
    private static final String USERNAME = "NGOCTM";
    private static final String PASSWORD = "100198";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static List<ImportInformation> imports;
    private static List<String> logErrors;
    public DBService() {
        super();
    }
    public static List<String> create(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);        
            if (connection != null) {
            String sql = "INSERT INTO \"IMPORT_EXCEL\"  " +
            "VALUES (?, ?, ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)";
            preparedStatement = connection.prepareStatement(sql);
            statement = connection.createStatement();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + e.getSQLState());
        }  
        for(int index = 0; index < imports.size(); index++){
            ImportInformation importInfor = imports.get(index);
            try {
                checkLineHasExist(statement, resultSet, importInfor);
                setPrepareStatement(preparedStatement, importInfor);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                String error = "Add error at line " + (index + 1) + " because " + e.getMessage();
                logErrors.add(error);
                System.out.println(error);
            }
        }   
        return logErrors;
    }

    public static boolean testConnec(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            logErrors.add(e.getMessage());
        }
        
        if(connection != null){
            return true;
        }
        return false;
    }

    public static void setImports(List<ImportInformation> imports) {
        DBService.imports = imports;
    }

    public static List<ImportInformation> getImports() {
        return imports;
    }


    public static void setLogErrors(List<String> logErrors) {
        DBService.logErrors = logErrors;
    }

    public static List<String> getLogErrors() {
        return logErrors;
    }

    private static void setPrepareStatement (PreparedStatement preparedStatement, ImportInformation importInfor) 
                        throws SQLException {
        preparedStatement.setString(1, importInfor.getMemberOrderID());
        preparedStatement.setString(2, importInfor.getMemberID());
        preparedStatement.setString(3, importInfor.getMemberName());
        preparedStatement.setString(4, importInfor.getStaffID());
        preparedStatement.setString(5, importInfor.getStaffName());
        preparedStatement.setString(6, importInfor.getMemberRole());
        preparedStatement.setString(7, importInfor.getMemberProvince());
        preparedStatement.setString(8, importInfor.getMemberDistrict());
        preparedStatement.setString(9, importInfor.getMemberWard());
        preparedStatement.setString(10, importInfor.getMemberAddress());
        preparedStatement.setString(11, importInfor.getMemberIDCard());
        preparedStatement.setString(12, importInfor.getMemberLoginAccount());
        preparedStatement.setString(13, importInfor.getMemberPhoneNumber());
        preparedStatement.setString(14, importInfor.getMemberPassword());
        preparedStatement.setString(15, importInfor.getEZ());
        preparedStatement.setString(16, importInfor.getDauNoi());
        preparedStatement.setString(17, importInfor.getMK());
        preparedStatement.setString(18, importInfor.getNVPT());
        preparedStatement.setString(19, importInfor.getCHPT());
    }

    private static void checkLineHasExist(Statement statement,ResultSet resultSet, ImportInformation importInfor) 
                    throws SQLException {
        String get = "SELECT * FROM  \"IMPORT_EXCEL\" where STAFF_ID = " + " '" + importInfor.getStaffID() + "'";
        resultSet = statement.executeQuery(get);
        int size = 0;
        while (resultSet.next()){
            size++;
        }
        if(size != 0){
            throw new SQLException("line has exist with staff_id = " + importInfor.getStaffID());
        }
    }
}
