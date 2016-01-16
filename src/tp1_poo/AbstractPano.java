/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_poo;

import java.awt.Container;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author Matthieu
 */
public abstract class AbstractPano extends JPanel{
    protected ChartPanel charti;
    

    public ChartPanel getCharti() {
        return charti;
    }

    public void setCharti(ChartPanel charti) {
        this.charti = charti;
    }
 

    CategoryDataset createDataset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    JFreeChart createChart(int i, CategoryDataset dataset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    JFreeChart createChart(CategoryDataset dataset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
