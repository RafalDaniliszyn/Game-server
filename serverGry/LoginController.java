package com.example.serverGry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class LoginController {

    @Autowired
    DatabaseConnection databaseConnection;


    @GetMapping("/mvc/login")
    public String getLogin(Model model){
        model.addAttribute("login","Podaj dane:");
        model.addAttribute("loginData", new LoginData());

        return "Account";
    }

    @PostMapping("/mvc/password")
    public String password(@ModelAttribute LoginData loginData, Model model) throws SQLException {
        int x;
        int y;
        ResultSet resultSet;
        resultSet = databaseConnection.statement.executeQuery("SELECT * FROM gracze WHERE name='"+loginData.name+"'");
        resultSet.next();
        if (loginData.password.equals(resultSet.getString("password"))){
            resultSet = databaseConnection.statement.executeQuery("SELECT * FROM gracze WHERE name='"+loginData.name+"'");
            resultSet.next();
            model.addAttribute("x", resultSet.getInt("x"));
            model.addAttribute("y", resultSet.getInt("y"));
            return "YourAccount";
        }


       return "Account";
    }

}



















