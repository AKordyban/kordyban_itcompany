package com.solvd.dao;

import com.solvd.configuration.AbstractDAO;
import com.solvd.dao.interfaces.IEmployeesDAO;
import com.solvd.model.EmployeesModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO extends AbstractDAO implements IEmployeesDAO {

    @Override
    public List<EmployeesModel> getAllEmployees() {
        List<EmployeesModel> allEmplooyees = new ArrayList<>();

        try{
            getResultSet("SELECT * FROM employees");
            while(resultSet.next()){
                EmployeesModel employeesModel = new EmployeesModel();
                employeesModel.setId(resultSet.getInt("id"));
                employeesModel.setFirstName(resultSet.getString("First Name"));
                employeesModel.setSecondName(resultSet.getString("Second Name"));
                employeesModel.setPosition(resultSet.getString("Position"));
                employeesModel.setOnlineShopesId(resultSet.getInt("OnlineShopes_id"));
                allEmplooyees.add(employeesModel);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allEmplooyees;
    }
}
