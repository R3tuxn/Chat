package core.main.actions;

import java.util.Scanner;

public class getMsg extends Thread {

    private Scanner sc;
    private String temp, IP;

    public getMsg(Scanner scanr, String ipaddr) {
        this.sc = scanr;
        this.IP = ipaddr;
    }

    @Override
    public void run() {
        try {
            while(true) {
                temp = sc.next();
                System.out.println(IP + ": " + temp);
            }
        } catch (Exception ex) {
            System.out.println("Error!");
        }
    }
}