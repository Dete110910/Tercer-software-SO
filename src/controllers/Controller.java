package controllers;

import views.ViewManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;

public class Controller implements ActionListener, KeyListener {

    private ViewManager viewManager;
    public Controller(){
        this.viewManager = new ViewManager(this, this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "CrearProceso":
                this.showCreateProcessDialog();
                break;
            case "AñadirProceso":
                this.addProcess();
                break;
            case "CancelarAñadirProceso":
                this.hideCreateProcessDialog();
                break;
            case "Salir":
                System.exit(0);
                break;

        }
    }


    private void showCreateProcessDialog(){
        this.viewManager.showCreateProcessDialog();
    }

    private void addProcess(){
        String nameProcess = this.viewManager.getNameProcess();
        BigInteger timeProcess = this.viewManager.getTimeProcess();
        boolean isBlocked = this.viewManager.getIsBlocked();
        boolean isSuspended = this.viewManager.getIsSuspended();
        boolean isResume = this.viewManager.getIsResume();



        this.viewManager.hideCreateProcessDialog();



    }

    private void hideCreateProcessDialog() {
        this.viewManager.hideCreateProcessDialog();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new Controller();
    }
}
