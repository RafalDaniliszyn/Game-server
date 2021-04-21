package com.example.serverGry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class Register {
    int newPlayerId;

    @Autowired
    DatabaseConnection databaseConnection;

    @GetMapping("/mvc/register")
    public String home(Model model) {
        model.addAttribute("helloMessage", "Podaj nick ktory chcesz zarejestrowac");
        model.addAttribute("fromNewPlayer", new NewPlayer());
        return "Register";
    }


    @PostMapping("/mvc/add")
    public String addArticle(@ModelAttribute NewPlayer fromNewPlayer, Model model, HttpServletRequest request) throws SQLException {
            System.out.println(request.getRemoteHost());

            databaseConnection.statement.executeUpdate("INSERT INTO gracze (name) VALUES ('"+fromNewPlayer.name+"')");
            databaseConnection.statement.executeUpdate("UPDATE gracze SET password='"+fromNewPlayer.password+"' WHERE name='"+fromNewPlayer.name+"'");
            ResultSet nextId = databaseConnection.statement.executeQuery("SELECT COUNT (*) FROM gracze");
            nextId.next();
            this.newPlayerId = nextId.getInt(1);
            databaseConnection.statement.executeUpdate("UPDATE gracze SET x='20', y='25', status='false', poziommapy='0', id='"+nextId.getInt(1)+"'WHERE name='"+fromNewPlayer.name+"'");
            model.addAttribute("twojeid","Twoje nowe ID: ");
            model.addAttribute("id",newPlayerId);
        return "Done";
        }
    }
