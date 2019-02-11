package com.sportsDataAnlyze.dataReplicator.service;


import com.sportsDataAnlyze.dataReplicator.enums.LeagueUrlEnum;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class ReplicationTaskService {
    private static final String DELIMETER = ",";

    public void createDataCSV(LeagueUrlEnum leagueUrlEnum){
        File directory = new File("data");
        String toFile = "data/" + leagueUrlEnum.name() + ".csv";
        File file = new File(toFile);
        directory.mkdir();
        try {
            FileUtils.deleteQuietly(file);
            file.createNewFile();
            FileUtils.copyURLToFile(new URL(leagueUrlEnum.getLink()), new File(toFile), 10000, 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyRawDataToDatabase(LeagueUrlEnum leagueUrlEnum) {
        String refereeCondition = "";
        if(checkNumberOfColumns(leagueUrlEnum)==62){
            refereeCondition = ",Referee text";
        };

        String deleteFootballTableQuery = "DROP TABLE IF EXISTS football."+leagueUrlEnum.name().toLowerCase();
        String createTableQuery = String.format("CREATE TABLE football.%s (" +
                "Div text, Date date, HomeTeam text, AwayTeam text,FTHG Integer,FTAG INTEGER ,FTR text,HTHG Integer,HTAG Integer,HTR text %s ,HS Integer, \"as\" Integer,HST Integer," +
                "AST Integer,HF Integer,AF Integer,HC Integer,AC Integer,HY Integer,AY Integer,HR Integer,AR Integer, B365H double precision, B365D double precision, B365A double precision," +
                "BWH double precision, BWD double precision, BWA double precision, IWH double precision, IWD double precision, IWA double precision, PSH double precision, PSD double precision, PSA double precision, WHH double precision, WHD double precision, WHA double precision, VCH double precision," +
                "VCD double precision, VCA double precision, Bb1X2 double precision, BbMxH double precision, BbAvH double precision, BbMxD double precision, BbAvD double precision," +
                "BbMxA double precision, BbAvA double precision, BbOU double precision,\"BbMx>2.5\" double precision, \"BbAv>2.5\" double precision, \"BbMx<2.5\" double precision, \"BbAv<2.5\" double precision," +
                "BbAH double precision, BbAHh double precision, BbMxAHH double precision, BbAvAHH double precision, BbMxAHA double precision, BbAvAHA double precision, PSCH double precision," +
                "PSCD double precision, PSCA double precision)",leagueUrlEnum.name().toLowerCase(),refereeCondition);

        String copyPostgres = "copy football." + leagueUrlEnum.name().toLowerCase() + " from '/home/tymon/Pulpit/sport_apps/football_data_analyze/dataReplicator/data/"+leagueUrlEnum.name()+".csv' DELIMITER ',' CSV HEADER";
        String idAlterTable = "ALTER TABLE football." + leagueUrlEnum.name().toLowerCase() + " ADD COLUMN id SERIAL PRIMARY KEY";

        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sports_data","postgres","bookmaker");
            Statement stmt = c.createStatement();
            stmt.executeUpdate(deleteFootballTableQuery);
            stmt.executeUpdate(createTableQuery);
            stmt.executeUpdate(copyPostgres);
            stmt.executeUpdate(idAlterTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int checkNumberOfColumns(LeagueUrlEnum leagueUrlEnum){
        int number=0;
        Path pathToFile = Paths.get("data/"+leagueUrlEnum.name()+".csv");
        try {
            BufferedReader bf = Files.newBufferedReader(pathToFile);
            String line = bf.readLine();
            String[] columnArr = line.split(DELIMETER);
            number = columnArr.length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
}
