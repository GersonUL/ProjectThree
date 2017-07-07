/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.Arista;
import Domain.Node;
import Domain.Nodo;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import Domain.metodoPrim;
import javax.swing.JPanel;

/**
 *
 * @author gerson
 */
public class panelDibujoGrafo extends JPanel implements MouseListener, MouseMotionListener {

    private List<Nodo> listaNodo;
    private List<Arista> listaAristas;
    private boolean bandera;
    private int contador;
    private PrincipalWindow pw;

    public panelDibujoGrafo(PrincipalWindow pw) {
        this.pw = pw;
        listaNodo = new ArrayList<Nodo>();
        listaAristas = new ArrayList<Arista>();
        bandera = false;
        contador = 65;
        addMouseListener(this);
        addMouseMotionListener(this);
    }//const  

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getSize().width, getSize().height);
        for (int i = 0; i < listaAristas.size(); i++) {
            Arista arista = listaAristas.get(i);
            if (arista.verde) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawLine(arista.x1, arista.y1, arista.x2, arista.y2);
            g.setColor(Color.RED);
            g.drawString("" + arista.peso, (arista.x1 + arista.x2) / 2, (arista.y1 + arista.y2) / 2);
        }
        for (int i = 0; i < listaNodo.size(); i++) {
            g.setColor(Color.BLACK);
            Nodo nodot = listaNodo.get(i);
            g.fillOval(nodot.x - 15, nodot.y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString("" + (char) nodot.numero, nodot.x - 7, nodot.y + 5);
        }
    }

    public void nuevo(char letra) {
        Nodo nodo = new Nodo();
        nodo.numero = letra;
        contador++;
        bandera = true;
        listaNodo.add(nodo);
    }

    public void limpia() {
        listaNodo.clear();
        listaAristas.clear();
        contador = 65;
        bandera = false;
        repaint();
    }

    public List<Nodo> nodos() {
        return listaNodo;
    }

    public void nuevaarista(char n1, char n2, int peso) {
        Arista arista;
        for (int i = 0; i < listaAristas.size(); i++) {
            arista = listaAristas.get(i);
            if ((arista.nodo1 == n1 && arista.nodo2 == n2) || (arista.nodo2 == n1 && arista.nodo1 == n2)) {
                //programa.muestramensaje("Ya existe la arista");
                return;
            }
        }
        arista = new Arista();
        arista.nodo1 = n1;
        arista.nodo2 = n2;
        arista.peso = peso;
        arista.verde = false;
        for (int i = 0; i < listaNodo.size(); i++) {
            Nodo nodot = listaNodo.get(i);
            if ((char) nodot.numero == n1) {
                arista.x1 = nodot.x;
                arista.y1 = nodot.y;
            } else if ((char) nodot.numero == n2) {
                arista.x2 = nodot.x;
                arista.y2 = nodot.y;
            }
        }
        listaAristas.add(arista);
        repaint();
    }

    public void prim() {
        metodoPrim prim = new metodoPrim();
        int aux = 0, nodOrig = 0, veces, veces2 = 0, nodDest;
        int[][] colaristas;
        int[][] recubridor;
        Arista ari;
        if (listaAristas.size() < 1) {
            System.out.println("No hay aristas");
            return;
        }
        for (int j = 1; j <= listaNodo.size(); j++) {
            aux += listaNodo.size() - j;
        }
        colaristas = new int[aux][3];
        veces = listaNodo.size() - 1;
        for (int k = 1; k <= aux; k++) {
            if (veces2++ == veces) {
                nodOrig++;
                veces--;
                veces2 = 1;
            }
            nodDest = nodOrig + veces2;
            colaristas[k - 1][0] = 0;
            for (int y = 0; y < listaAristas.size(); y++) {
                ari = listaAristas.get(y);
                if (nodOrig + 65 == ari.nodo1 && nodDest + 65 == ari.nodo2) {
                    colaristas[k - 1][0] = ari.peso;
                } else if (nodOrig + 65 == ari.nodo2 && nodDest + 65 == ari.nodo1) {
                    colaristas[k - 1][0] = ari.peso;
                }
            }
            colaristas[k - 1][1] = nodOrig;
            colaristas[k - 1][2] = nodDest;
        }
        recubridor = prim.aplicaPrim(colaristas, listaNodo.size());
        veces = 0;
        for (int y = 0; y < listaAristas.size(); y++) {
            listaAristas.get(y).verde = false;
        }
        for (int l = 0; l < recubridor.length; l++) {
            for (int y = 0; y < listaAristas.size(); y++) {
                ari = listaAristas.get(y);
                if (ari.verde) {
                    continue;
                }
                if (recubridor[l][1] + 65 == ari.nodo1 && recubridor[l][2] + 65 == ari.nodo2) {
                    ari.verde = true;
                }
                if (recubridor[l][1] + 65 == ari.nodo2 && recubridor[l][2] + 65 == ari.nodo1) {
                    ari.verde = true;
                }
            }
            veces += recubridor[l][0];
        }
        repaint();
        System.out.println("Costo total: " + veces);
    }

    public void mouseClicked(MouseEvent e) {
        if (bandera) {
            bandera = false;
            repaint();
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        if (bandera) {
            Nodo nodo = listaNodo.get(listaNodo.size() - 1);
            nodo.x = e.getX();
            nodo.y = e.getY();
            repaint();
        }
    }

}//class
