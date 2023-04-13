package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel {


    private JLabel titleMenu;
    private ButtonMenu addProcess, modifyProcess, deleteProcess, reports, sendProcess, viewManual, exit;


    public PanelMenu(ActionListener actionListener){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#4a4e69"));
        this.setPreferredSize(new Dimension(350,80));
        this.setMaximumSize(new Dimension(350,80));
        this.setMinimumSize(new Dimension(350,80));
        initComponents(actionListener);
        this.setVisible(true);
    }

    private void initComponents(ActionListener actionListener){
        this.titleMenu = new JLabel("Procesos");
        this.titleMenu.setForeground(Color.WHITE);
        this.titleMenu.setFont(ConstantsGUI.FONT_MENU_TITLE);
        this.addComponent(titleMenu, 0, 1);

        this.addProcess = new ButtonMenu("Crear");
        this.addProcess.addActionListener(actionListener);
        this.addProcess.setActionCommand("CrearProceso");
        this.addComponent(this.addProcess, 0, 2);

        this.modifyProcess = new ButtonMenu("Modificar");
        this.modifyProcess.addActionListener(actionListener);
        this.modifyProcess.setActionCommand("ModificarProceso");
        addComponent(this.modifyProcess, 0, 3);

        this.deleteProcess = new ButtonMenu("Eliminar");
        this.deleteProcess.addActionListener(actionListener);
        this.deleteProcess.setActionCommand("EliminarProceso");
        addComponent(this.deleteProcess, 0, 4);

        this.reports = new ButtonMenu("Reportes");
        this.reports.addActionListener(actionListener);
        this.reports.setActionCommand("Reportes");
        this.addComponent(this.reports, 0, 5);

        this.sendProcess = new ButtonMenu("Iniciar Simulación");
        this.sendProcess.addActionListener(actionListener);
        this.sendProcess.setActionCommand("Enviar");
        this.addComponent(this.sendProcess, 0, 6);

        this.viewManual = new ButtonMenu("Manual de usuario");
        this.viewManual.addActionListener(actionListener);
        this.viewManual.setActionCommand("ManualUsuario");
        this.addComponent(this.viewManual, 0, 7);

        this.exit = new ButtonMenu("Salir");
        this.exit.addActionListener(actionListener);
        this.exit.setActionCommand("Salir");
        this.addComponent(exit, 0, 8);


    }

    public void addComponent(JComponent component, int x, int y){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(component, gbc);
    }
}
