/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_poo;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author Matthieu
 */
public class Fenetre extends JFrame implements ActionListener{
    
    AbstractPano graph;
    JMenuBar bar;
    JMenu menu;
    JMenuItem c1;
    JMenuItem c2;
    JMenuItem c3;
    CategoryDataset datasets[];
    JFreeChart charts[];
    ChartPanel panels[];
    final int nb_diagrames=4;
    
    public Fenetre(){
        init();
        c1.addActionListener(this);
        c2.addActionListener(this);
        c3.addActionListener(this);
        
    }
    
    public void init(){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         bar = new JMenuBar();
        menu = new JMenu("Affichage");
        c1 =new JMenuItem("pays/continent");
        c2 =new JMenuItem("V-N-D/Champion");
        c3 =new JMenuItem("Multi");
        menu.add(c1);
        menu.add(c2);
        menu.add(c3);
        
        bar.add(menu);
        
        this.setJMenuBar(bar);
        graph =new Barres();
        
        datasets = new CategoryDataset[nb_diagrames];
	charts = new JFreeChart[nb_diagrames];
	panels = new ChartPanel[nb_diagrames];
	for (int i = 0; i < nb_diagrames; i++)
	{
		datasets[i] = graph.createDataset();
		charts[i] = graph.createChart(datasets[i]);
		panels[i] = new ChartPanel(charts[i]);
	}

	CategoryPlot categoryplot = (CategoryPlot)charts[1].getPlot();
	CategoryPlot categoryplot1 = (CategoryPlot)charts[2].getPlot();
	CategoryPlot categoryplot2 = (CategoryPlot)charts[3].getPlot();
	categoryplot.getRangeAxis().setInverted(true);
	categoryplot2.getRangeAxis().setInverted(true);
	categoryplot1.setOrientation(PlotOrientation.HORIZONTAL);
	categoryplot2.setOrientation(PlotOrientation.HORIZONTAL);
	this.add(panels[0]);
	this.add(panels[1]);
	this.add(panels[2]);
	this.add(panels[3]);
	setPreferredSize(new Dimension(800, 600));
        
        //graph camembert
        
       /* graph =new Camembert();
        this.add(graph);
        setContentPane(graph.getCharti());*/
        
        /*graph =new Barres();
        this.add(graph);
        setContentPane(graph.getCharti());*/
        this.pack();
        

    }
    
    public void refresh(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        menu.add(c1);
        menu.add(c2);
        menu.add(c3);
        
        bar.add(menu);
        
        this.setJMenuBar(bar);
        
        this.pack();
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==c1){
            graph =new Camembert();
            this.add(graph);
            setContentPane(graph.getCharti());
            refresh();
        }
        if(e.getSource()==c2){
            graph =new Barres();
            this.add(graph);
            setContentPane(graph.getCharti());
            refresh();
        }
        if(e.getSource()==c3){
            graph =new Barres();
            this.add(graph);
            setContentPane(graph.getCharti());
            
            refresh();
        }
    }
}
