/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Covid19;

/**
 *
 * @author Admin
 */


import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.*;
import javax.swing.JFrame;

import Covid19.Administrator;

public class VaccinationApp extends JFrame {
    private static Administrator listName = new Administrator();
    public static void main(final String... args) throws ParseException {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        loginForm.setSize(1092,800);
        loginForm.setLocation(100, 100);
    }
}
 

