package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.math.BigInteger;

public class ViewManager extends JFrame {

    private PanelMenu panelMenu;
    private PanelTable panelTable;
    private DialogCreateProcess dialogCreateProcess;
    private PanelMenuReport panelMenuReport;

    private Object[][] inQueue, readyProcess, dispatch, expiration, execution, wait, block, endIOBlockReady,
    suspendBlockToSuspendBlock, resumeSuspendBlockToBlock, suspendBlock, endIOSuspendBlockToSuspendReady,
    suspendReady, resumeSuspendReadyToReady, suspendReadyToSuspendReady, suspendExecutionToSuspendReady, finished;

    public ViewManager(ActionListener actionListener, KeyListener keyListener){
        this.setLayout(new BorderLayout());
        this.setTitle("Tercer Software");
        this.setFont(ConstantsGUI.MAIN_MENU);
        this.setSize(700, 500);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.decode("#f2e9e4"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.initComponents(actionListener, keyListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener, KeyListener keyListener){
        this.panelMenu = new PanelMenu(actionListener);
        this.add(panelMenu, BorderLayout.WEST);

        this.panelTable = new PanelTable();
        this.add(panelTable, BorderLayout.CENTER);

        this.dialogCreateProcess = new DialogCreateProcess(actionListener, keyListener);
        this.panelMenuReport = new PanelMenuReport(actionListener);

        this.readyProcess = new Object[0][0];

    }


    public void showCreateProcessDialog() {
        this.dialogCreateProcess.changeButtonToCreate();
        this.dialogCreateProcess.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void showModifyProcessDialog(){
        this.dialogCreateProcess.changeButtonToModify();
        this.dialogCreateProcess.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void hideCreateAndModifyProcessDialog(){
        this.dialogCreateProcess.setVisible(false);
        this.dialogCreateProcess.cleanAllFields();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void showTableProcessPanel(){
       /* this.hideAllPanels();
        panelTableProcess.setVisible(true);
        this.add(panelTableProcess, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);*/
    }

    public int getIndexDataInTable(){
        return this.panelTable.getIndexDataProcess();
    }

    public void setNameProcess(String nameProcess){
        this.dialogCreateProcess.setNameProcess(nameProcess);
    }
    public String getNameProcess(){
        return this.dialogCreateProcess.getNameProcess();
    }


    public void setTimeProcess(BigInteger timeProcess){
        this.dialogCreateProcess.setTimeProcess(timeProcess);
    }
    public BigInteger getTimeProcess(){
        return this.dialogCreateProcess.getTimeProcess();
    }

    public void setIsBlock(boolean isBlock){
        this.dialogCreateProcess.setIsBlock(isBlock);
    }
    public boolean getIsBlocked() {
        return this.dialogCreateProcess.getIsBlocked();
    }

    public void setIsSuspended(boolean isSuspended){
        this.dialogCreateProcess.setIsSuspended(isSuspended);
    }

    public boolean getIsSuspended(){
        return this.dialogCreateProcess.getIsSuspended();
    }


    public void setIsResume(boolean isResume){
        this.dialogCreateProcess.setIsResume(isResume);
    }
    public boolean getIsResume(){
        return this.dialogCreateProcess.getIsResume();
    }

    public int getReadyProcessListLength(){
        return this.readyProcess.length;
    }

    public void changeToReportsMenu(){
        this.remove(panelMenu);
        this.add(panelMenuReport, BorderLayout.WEST);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void changeToMainMenu(){
        this.remove(panelMenuReport);
        this.add(panelMenu, BorderLayout.WEST);
        SwingUtilities.updateComponentTreeUI(this);
    }


    public void setValuesToTable(Object[][] inQueueList) {
        Object[][] newQueueList =  this.parseValuesIsBlockAndIsSuspended(inQueueList);
        DefaultTableModel defaultTableModel = new DefaultTableModel(newQueueList, ConstantsGUI.HEADERS);
        this.panelTable.setTableProcess(defaultTableModel);
    }
    public void setValuesToTableProcessInQueue(Object[][] queueListAsStringList){
       Object[][] newQueueList =  this.parseValuesIsBlock(queueListAsStringList);
        DefaultTableModel defaultTableModel = new DefaultTableModel(newQueueList, ConstantsGUI.HEADERS);
        this.panelTable.setTableProcess(defaultTableModel);
    }
    private Object[][] parseValuesIsBlock(Object[][] queueList){
        int size = queueList.length;
        for(int i = 0; i < size; i++){
            queueList[i][2] = queueList[i][2].equals(true) ? "Sí" : "No";
        }
        return queueList;
    }

    private Object[][] parseValuesIsBlockAndIsSuspended(Object[][] queueList){
        int size = queueList.length;
        for(int i = 0; i < size; i++){
            queueList[i][2] = queueList[i][2].equals(true) ? "Sí" : "No";
            queueList[i][3] = queueList[i][3].equals(true) ? "Sí" : "No";
            queueList[i][4] = queueList[i][4].equals(true) ? "Sí" : "No";

        }
        return queueList;
    }


    public void setInQueue(Object[][] inQueue) {
        this.inQueue = inQueue;
    }

    public void setReadyProcess(Object[][] readyProcess) {
        this.readyProcess = readyProcess;
    }

    public void setDispatch(Object[][] dispatch) {
        this.dispatch = dispatch;
    }

    public void setExpiration(Object[][] expiration) {
        this.expiration = expiration;
    }

    public void setExecution(Object[][] execution) {
        this.execution = execution;
    }

    public void setWait(Object[][] wait) {
        this.wait = wait;
    }

    public void setBlock(Object[][] block) {
        this.block = block;
    }

    public void setEndIOBlockReady(Object[][] endIOBlockReady) {
        this.endIOBlockReady = endIOBlockReady;
    }

    public void setSuspendBlockToSuspendBlock(Object[][] suspendBlockToSuspendBlock) {
        this.suspendBlockToSuspendBlock = suspendBlockToSuspendBlock;
    }

    public void setResumeSuspendBlockToBlock(Object[][] resumeSuspendBlockToBlock) {
        this.resumeSuspendBlockToBlock = resumeSuspendBlockToBlock;
    }

    public void setSuspendBlock(Object[][] suspendBlock) {
        this.suspendBlock = suspendBlock;
    }

    public void setEndIOSuspendBlockToSuspendReady(Object[][] endIOSuspendBlockToSuspendReady) {
        this.endIOSuspendBlockToSuspendReady = endIOSuspendBlockToSuspendReady;
    }

    public void setSuspendReady(Object[][] suspendReady) {
        this.suspendReady = suspendReady;
    }

    public void setResumeSuspendReadyToReady(Object[][] resumeSuspendReadyToReady) {
        this.resumeSuspendReadyToReady = resumeSuspendReadyToReady;
    }

    public void setSuspendReadyToSuspendReady(Object[][] suspendReadyToSuspendReady) {
        this.suspendReadyToSuspendReady = suspendReadyToSuspendReady;
    }

    public void setSuspendExecutionToSuspendReady(Object[][] suspendExecutionToSuspendReady) {
        this.suspendExecutionToSuspendReady = suspendExecutionToSuspendReady;
    }

    public void setFinished(Object[][] finished) {
        this.finished = finished;
    }
}
