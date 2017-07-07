/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.Nodo;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author gerson
 */
public class PrincipalWindow extends JFrame implements ActionListener {

    List listaNodo1;
    ArrayList lista;
    List listaNodo2;
    private JDialog cuadroDialogo;
    private JButton btnInsertNode, btnInsertArist, btnAristac;
    private JTextField txfInsertNode, txfPeso;
    private panelDibujoGrafo pdg;
    private JLabel etiqueta, lblNode;
    private JComboBox jcbOpciones;

    public PrincipalWindow() {
        super("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);
        init();
    }//const 

    public void init() {
        this.lista = new ArrayList();
        this.listaNodo1 = new List();
        this.listaNodo2 = new List();
        this.pdg = new panelDibujoGrafo(this);
        this.pdg.setBounds(10, 10, 500, 500);
        this.pdg.setBackground(Color.BLACK);
        this.add(pdg);
        
        this.lblNode = new JLabel("Node: ");
        this.lblNode.setBounds(550, 25, 150, 30);
        this.add(lblNode);
        this.txfInsertNode = new JTextField();
        this.txfInsertNode.setBounds(600, 25, 150, 30);
        this.add(txfInsertNode);
        this.btnInsertNode = new JButton("Insert Node");
        this.btnInsertNode.setBounds(550, 70, 120, 40);
        this.btnInsertNode.addActionListener(this);
        this.add(btnInsertNode); 
        
        this.btnInsertArist = new JButton("Insert Arist");
        this.btnInsertArist.setBounds(550, 150, 120, 40);
        this.btnInsertArist.addActionListener(this);
        this.add(btnInsertArist);
        
        this.jcbOpciones=new JComboBox();
        this.jcbOpciones.addItem("");
        this.jcbOpciones.addItem("Prim");
        this.jcbOpciones.addItem("Dijkstra");
        this.jcbOpciones.addItem("Montecarlo");
        this.jcbOpciones.setBounds(550,270,120,40);
        this.add(this.jcbOpciones);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.txfPeso = new JTextField(5);
        this.btnAristac = new JButton("insertar arista");
        this.btnAristac.addActionListener(this);
        cuadroDialogo = new JDialog(this, "Agregar arista", true);
        cuadroDialogo.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cuadroDialogo.setVisible(false);
            }
        });
        cuadroDialogo.setLayout(new GridLayout(2, 4));
        cuadroDialogo.add(new Label("Desde nodo:"));
        cuadroDialogo.add(listaNodo1);
        cuadroDialogo.add(new Label("Hasta nodo:"));
        cuadroDialogo.add(listaNodo2);
        cuadroDialogo.add(new Label("Peso:"));
        cuadroDialogo.add(txfPeso);
        cuadroDialogo.add(btnAristac);
    }//init

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (btnInsertNode == e.getSource()) {         
               if(txfInsertNode.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No ingresó una letra");
            
        }else{
            pdg.nuevo(this.txfInsertNode.getText().charAt(0));
            this.txfInsertNode.setText("");
               
               }
        } else if (e.getSource() == btnInsertArist) {
            lista = (ArrayList) pdg.nodos();
            listaNodo1.removeAll();
            listaNodo2.removeAll();
            for (int i = 0; i < lista.size(); i++) {
                Nodo nodot = (Nodo) lista.get(i);
                listaNodo1.add("" + (char) nodot.numero);
                listaNodo2.add("" + (char) nodot.numero);
            }
            cuadroDialogo.pack();
            txfPeso.setText("");
            cuadroDialogo.setLocationRelativeTo(this);
            cuadroDialogo.setVisible(true);

        } else if (e.getSource() == btnAristac) {
            creaarista();
            cuadroDialogo.setVisible(false);
        }
    }//action

    private void creaarista() {
        String nodo1 = listaNodo1.getSelectedItem();
        String nodo2 = listaNodo2.getSelectedItem();
        int valpeso = Integer.parseInt(txfPeso.getText());
        pdg.nuevaarista(nodo1.charAt(0), nodo2.charAt(0), valpeso);
    }//creaArista

    
}//class
