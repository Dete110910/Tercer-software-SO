package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.math.BigInteger;
import java.security.Key;

public class ViewManager extends JFrame {

    private PanelMenu panelMenu;
    private PanelTable panelTable;
    private DialogCreateProcess dialogCreateProcess;

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

    }

    public void hideAllPanes(){
        this.panelMenu.setVisible(false);
    }

    public void showCreateProcessDialog() {
        this.dialogCreateProcess.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void hideCreateProcessDialog(){
        this.dialogCreateProcess.setVisible(false);
        this.dialogCreateProcess.cleanAllFields();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public String getNameProcess(){
        return this.dialogCreateProcess.getNameProcess();
    }

    public BigInteger getTimeProcess(){
        return this.dialogCreateProcess.getTimeProcess();
    }

    public boolean getIsBlocked() {
        return this.dialogCreateProcess.getIsBlocked();
    }

    public boolean getIsSuspended(){
        return this.dialogCreateProcess.getIsSuspended();
    }

    public boolean getIsResume(){
        return this.dialogCreateProcess.getIsResume();
    }

}
