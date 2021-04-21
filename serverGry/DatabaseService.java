package com.example.serverGry;


import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class DatabaseService {

    @Autowired
    Player player;
    @Autowired
    OnlinePlayer onlinePlayer;

    @Autowired
    DatabaseConnection databaseConnection;

    @PutMapping("/tester")
    public void test(@RequestBody Player player) throws SQLException, ParseException {
        databaseConnection.statement.executeUpdate("UPDATE gracze SET x='" + player.polozenieNaTablicyX + "',y='" + player.polozenieNaTablicyY +
                "',poziommapy='"+ player.poziomMapy+"',status='"+ player.status+"' WHERE name='" + player.name+ "'");
    }

    @GetMapping("/downloaddata")
    public OnlinePlayer onlinePlayer(@RequestParam int id) throws SQLException {
        databaseConnection.result =  databaseConnection.statement.executeQuery("SELECT * FROM gracze WHERE id='"+id+"'");
        databaseConnection.result.next();
        onlinePlayer.status = databaseConnection.result.getBoolean("status");
        onlinePlayer.name = databaseConnection.result.getString("name");
        onlinePlayer.x = databaseConnection.result.getInt("x");
        onlinePlayer.y = databaseConnection.result.getInt("y");
        onlinePlayer.id = databaseConnection.result.getInt("id");
        onlinePlayer.poziomMapy = databaseConnection.result.getInt("poziomMapy");
        onlinePlayer.wiadomosc = databaseConnection.result.getString("wiadomosc");
        return onlinePlayer;
    }

    @GetMapping("/onlineplayers")
    public OnlinePlayer onlinePlayer() throws SQLException {
        databaseConnection.result =  databaseConnection.statement.executeQuery("SELECT count(*) FROM gracze");
        databaseConnection.result.next();
        onlinePlayer.liczbaGraczy = databaseConnection.result.getInt(1);
        return onlinePlayer;
    }

    @PutMapping("/sendMessage")
    public void sendMessage(@RequestBody Player player) throws SQLException {
        databaseConnection.statement.executeUpdate("UPDATE gracze SET wiadomosc='"+ player.wiadomosc+"'WHERE name='"+ player.name+"'");
    }

    @PutMapping("/statusfalse")
    public void setStatus(@RequestBody Player player) throws SQLException {
        databaseConnection.statement.executeUpdate("UPDATE gracze SET status='false' WHERE name='"+ player.name+"'");
    }


}
