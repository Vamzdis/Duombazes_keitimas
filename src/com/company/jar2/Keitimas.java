package com.company.jar2;

import javax.lang.model.element.Name;
import java.sql.*;
import java.util.Scanner;


/**
 * Created by Ignas on 2017.03.14.
 */
public class Keitimas {
    private Connection connection;
    Scanner sc = new Scanner(System.in);

    public Keitimas() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs",
                    "root",
                    "");

        } catch (Exception klaida) {
            System.out.println(klaida);
        }

    }

    public void pasisveikink() {

        System.out.println("Sveiki, as galiu pakeisti arba istrinti duomenis is Studentu lenteles");
    }

    public void paklausk() {
        System.out.println("Ar norite pakeisti ar trinti duomenis is Studentu lenteles?");
        System.out.println("Pakeisti: 1");
        System.out.println("Trinti: 2");
    }

    public void nuspresk() {
        Scanner sc = new Scanner(System.in);
        int skaicius = sc.nextInt();
        switch (skaicius) {
            case 1:
                System.out.println("Jus pasirinkote ivesti duomenis");
                redagavimas();


                break;
            case 2:
                System.out.println("Jus pasirinkote istrinti duomenis");
                System.out.println("Kuri irasa norite istrinti pagal studento ID?");
                istrynimas();

        }
    }


    private void redagavimas() {

        System.out.println("Lentele 1: Studentai");
        try {

                String insertTableSQL = "INSERT INTO students" + "(`Name`,`Surname`,`Phone`,`Email`) VALUES" + "(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
                System.out.println("Iveskite varda");
                String Name = sc.next();
                System.out.println("Iveskite pavarde");
                String Surname =sc.next();
                System.out.println("Iveskite telefona");
                int Phone = sc.nextInt();
                System.out.println("Iveskite Emaila");
                String Email = sc.next();
                preparedStatement.setString(1, Name);
                preparedStatement.setString(2, Surname);
                preparedStatement.setInt(3, Phone);
                preparedStatement.setString(4, Email);
                preparedStatement.executeUpdate();



        } catch (Exception klaida) {
            System.out.println(klaida);

        }
    }
        private void istrynimas(){


            try {
                System.out.println("Ivesti ID studento kuri norite istrinti");
                int id = sc.nextInt();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM `students` WHERE `students`.`id` = " + id + ";");
                statement.executeUpdate();

            } catch (Exception klaida) {
                System.out.println(klaida);

            }
    }

    }


