package controllers;

import models.Process;
import models.ProcessManager;
import views.ViewManager;
import views.Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigInteger;

public class Controller implements ActionListener, KeyListener {

    private ViewManager viewManager;
    private ProcessManager processManager;
    public Controller(){
        this.viewManager = new ViewManager(this, this);
        this.processManager = new ProcessManager();
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
            case "ModificarProceso":
                this.showModifyProcessDialog();
                break;
            case "ConfirmarModificacion":
                this.modifyProcess();
                break;
            case "EliminarProceso":
                this.deleteProcess();
                break;
            case "Reportes":
                this.changeToReportsMenu();
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

        if(!processManager.isAlreadyName(nameProcess) && !nameProcess.trim().isEmpty()){
            Process newProcess = new Process(nameProcess, timeProcess, isBlocked, isSuspended, isResume);
            processManager.addToInQueue(newProcess);
            viewManager.setValuesToTable(processManager.getListAsMatrixObject(processManager.getInQueue()));
            viewManager.hideCreateProcessDialog();
        }
        else {
            Utilities.showErrorDialog("Ya existe un proceso con este nombre", "Error");
        }


    }

    private void hideCreateProcessDialog() {
        this.viewManager.hideCreateProcessDialog();
    }

    private void showModifyProcessDialog(){
        if(this.viewManager.getIndexDataToModify() == -1){
            Utilities.showErrorDialog("Debe seleccionar un proceso", "Error");
        }
        else {
         this.viewManager.setNameProcess("Name");
         this.viewManager.setTimeProcess(new BigInteger("124"));
         this.viewManager.setIsBlock(true);
         this.viewManager.setIsSuspended(true);
         this.viewManager.setIsResume(true);
         this.viewManager.showModifyProcessDialog();
        }

    }

    private void modifyProcess(){
        System.out.println("Sí, modifiqué");
    }

    private void deleteProcess(){
        if(this.viewManager.getIndexDataToModify() == -1){
            Utilities.showErrorDialog("Debe seleccionar un proceso", "Error");
        }
        else {
            /* Lógica para eliminar un proceso */
        }
    }

    private void changeToReportsMenu(){
        if(this.viewManager.getReadyProcessListLenght() == 0){
            Utilities.showErrorDialog("Debe iniciar la simulación primero", "Error");
        }
        else {
            this.viewManager.changeToReportsMenu();
        }
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
