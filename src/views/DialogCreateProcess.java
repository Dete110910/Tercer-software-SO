package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.math.BigInteger;

public class DialogCreateProcess extends JDialog {

    private Button create, cancel;

    private JLabel nameProcess, timeProcess, blockProcess, suspendProcess, resumeProcess;
    private JTextField inputNameProcess, inputTimeProcess;

    private JRadioButton yesBlockProcess, noBlockProcess, yesSuspendProcess, noSuspendProcess, yesResumeProcess, noResumeProcess;

    private ButtonGroup blockProcessGroup, suspendProcessGroup, resumeProcessGroup;

    private JPanel panelBlockButtons, panelSuspendButtons, panelResumeButtons;


    public DialogCreateProcess(ActionListener actionListener, KeyListener keyListener) {
        this.setModal(true);
        this.setTitle("Crear Proceso");
        this.setLayout(new GridBagLayout());
        this.setFont(ConstantsGUI.MAIN_MENU);
        this.setSize(420, 320);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.decode("#C9ADA7"));
        initComponents(actionListener, keyListener);
    }

    private void initComponents(ActionListener actionListener, KeyListener keyListener) {
        this.nameProcess = new JLabel("Nombre");
        this.nameProcess.setFont(ConstantsGUI.FONT_TITLE_INPUTS);
        this.addComponent(this.nameProcess, 0, 0);

        this.inputNameProcess = new JTextField(10);
        this.inputNameProcess.setSize(100, 50);
        this.inputNameProcess.setPreferredSize(new Dimension(100, 30));
        this.inputNameProcess.setBackground(Color.WHITE);
        this.inputNameProcess.setFont(ConstantsGUI.FONT_INPUTS);
        this.addComponent(this.inputNameProcess, 1, 0);

        this.timeProcess = new JLabel("Tiempo");
        this.timeProcess.setFont(ConstantsGUI.FONT_TITLE_INPUTS);
        this.addComponent(this.timeProcess, 0, 1);

        this.inputTimeProcess = new JTextField(10);
        this.inputTimeProcess.addKeyListener(keyListener);
        this.inputTimeProcess.setSize(100, 50);
        this.inputTimeProcess.setPreferredSize(new Dimension(100, 30));
        this.inputTimeProcess.setBackground(Color.WHITE);
        this.inputTimeProcess.setFont(ConstantsGUI.FONT_INPUTS);
        this.addComponent(this.inputTimeProcess, 1, 1);

        this.blockProcess = new JLabel("Bloquear");
        this.blockProcess.setFont(ConstantsGUI.FONT_TITLE_INPUTS);
        addComponent(blockProcess, 0, 2);

        this.blockProcessGroup = new ButtonGroup();

        this.yesBlockProcess = new JRadioButton("Sí");
        this.yesBlockProcess.setBackground(Color.decode("#C9ADA7"));
        this.yesBlockProcess.setForeground(Color.BLACK);
        this.yesBlockProcess.setFont(ConstantsGUI.FONT_MENU_ACTIONS);

        this.noBlockProcess = new JRadioButton("No");
        this.noBlockProcess.setBackground(Color.decode("#C9ADA7"));
        this.noBlockProcess.setForeground(Color.BLACK);
        this.noBlockProcess.setFont(ConstantsGUI.FONT_MENU_ACTIONS);

        this.blockProcessGroup.add(this.yesBlockProcess);
        this.blockProcessGroup.add(this.noBlockProcess);
        this.yesBlockProcess.setSelected(true);

        this.panelBlockButtons = new JPanel();
        this.panelBlockButtons.setBackground(Color.decode("#C9ADA7"));
        this.panelBlockButtons.add(this.yesBlockProcess);
        this.panelBlockButtons.add(this.noBlockProcess);

        this.addComponent(this.panelBlockButtons, 1, 2);

        /* Suspend Buttons */

        this.suspendProcess = new JLabel("Suspender");
        this.suspendProcess.setFont(ConstantsGUI.FONT_TITLE_INPUTS);
        this.addComponent(this.suspendProcess, 0, 3);

        this.yesSuspendProcess = new JRadioButton("Sí");
        this.yesSuspendProcess.setBackground(Color.decode("#C9ADA7"));
        this.yesSuspendProcess.setForeground(Color.BLACK);
        this.yesSuspendProcess.setFont(ConstantsGUI.FONT_MENU_ACTIONS);

        this.noSuspendProcess = new JRadioButton("No");
        this.noSuspendProcess.setBackground(Color.decode("#C9ADA7"));
        this.noSuspendProcess.setForeground(Color.BLACK);
        this.noSuspendProcess.setFont(ConstantsGUI.FONT_MENU_ACTIONS);

        this.suspendProcessGroup = new ButtonGroup();


        this.suspendProcessGroup.add(this.yesSuspendProcess);
        this.suspendProcessGroup.add(this.noSuspendProcess);
        this.yesSuspendProcess.setSelected(true);

        this.panelSuspendButtons = new JPanel();
        this.panelSuspendButtons.setBackground(Color.decode("#C9ADA7"));
        this.panelSuspendButtons.add(this.yesSuspendProcess);
        this.panelSuspendButtons.add(this.noSuspendProcess);

        this.addComponent(this.panelSuspendButtons, 1, 3);

        /* Resume Buttons */

        this.resumeProcess = new JLabel("Reanudar");
        this.resumeProcess.setFont(ConstantsGUI.FONT_TITLE_INPUTS);
        this.addComponent(this.resumeProcess, 0, 4);

        this.yesResumeProcess = new JRadioButton("Sí");
        this.yesResumeProcess.setBackground(Color.decode("#C9ADA7"));
        this.yesResumeProcess.setForeground(Color.BLACK);
        this.yesResumeProcess.setFont(ConstantsGUI.FONT_MENU_ACTIONS);

        this.noResumeProcess = new JRadioButton("No");
        this.noResumeProcess.setBackground(Color.decode("#C9ADA7"));
        this.noResumeProcess.setForeground(Color.BLACK);
        this.noResumeProcess.setFont(ConstantsGUI.FONT_MENU_ACTIONS);

        this.resumeProcessGroup = new ButtonGroup();

        this.resumeProcessGroup.add(this.yesResumeProcess);
        this.resumeProcessGroup.add(this.noResumeProcess);
        this.yesResumeProcess.setSelected(true);

        this.panelResumeButtons = new JPanel();
        this.panelResumeButtons.setBackground(Color.decode("#C9ADA7"));
        this.panelResumeButtons.add(this.yesResumeProcess);
        this.panelResumeButtons.add(this.noResumeProcess);


        this.addComponent(this.panelResumeButtons, 1, 4);

        this.create = new Button("Añadir");
        this.create.addActionListener(actionListener);
        this.create.setActionCommand("AñadirProceso");
        this.create.setPreferredSize(new Dimension(150, 35));
        this.addComponent(create, 0, 5);

        this.cancel = new Button("Cancelar");
        this.cancel.addActionListener(actionListener);
        this.cancel.setActionCommand("CancelarAñadirProceso");
        this.cancel.setPreferredSize(new Dimension(150, 35));
        this.addComponent(cancel, 1, 5);

    }

    public void addComponent(JComponent component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(component, gbc);
    }


    public void setNameProcess(String nameProcess){
        this.inputNameProcess.setText(nameProcess);
    }
    public String getNameProcess(){
        return inputNameProcess.getText();
    }

    public void setTimeProcess(BigInteger timeProcess){
        this.inputTimeProcess.setText(timeProcess.toString());
    }

    public BigInteger getTimeProcess(){
        BigInteger timeProcess = new BigInteger("0");
        try {
            timeProcess = new BigInteger(this.inputTimeProcess.getText());
        }catch (NumberFormatException numberFormatException){
            System.out.println("Error al convertir un número tan grande");

        }
        return timeProcess;
    }


    public void setIsBlock(boolean isBlock){
        if(isBlock){
            this.yesBlockProcess.setSelected(true);
            this.noBlockProcess.setSelected(false);
        }
        else{
            this.yesBlockProcess.setSelected(false);
            this.noBlockProcess.setSelected(true);
        }
    }
    public void setIsSuspended(boolean isSuspended){
        if(isSuspended){
            this.yesSuspendProcess.setSelected(true);
            this.noSuspendProcess.setSelected(false);
        }
        else{
            this.yesSuspendProcess.setSelected(false);
            this.noSuspendProcess.setSelected(true);
        }
    }
    public void setIsResume(boolean isResume){
        if(isResume){
            this.yesResumeProcess.setSelected(true);
            this.noResumeProcess.setSelected(false);
        }
        else{
            this.yesResumeProcess.setSelected(false);
            this.noResumeProcess.setSelected(true);
        }
    }
    public boolean getIsBlocked() {
        return this.yesBlockProcess.isSelected();
    }
    public boolean getIsSuspended() {
        return this.yesSuspendProcess.isSelected();
    }
    public boolean getIsResume() {
        return this.yesResumeProcess.isSelected();
    }

    public void changeButtonToModify(){
        this.create.setText("Modificar");
        this.create.setActionCommand("ConfirmarModificacion");
    }

    public void changeButtonToCreate(){
        this.create.setText("Añadir");
        this.create.setActionCommand("AñadirProceso");
    }

    public void cleanAllFields(){
        this.inputNameProcess.setText("");
        this.inputTimeProcess.setText("");
        this.yesBlockProcess.setSelected(true);
        this.yesSuspendProcess.setSelected(true);
        this.yesResumeProcess.setSelected(true);
    }
}
