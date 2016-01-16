/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1_poo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Matthieu
 */
public class Barres extends AbstractPano{
   
    public Barres() {
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        charti = new ChartPanel(chart);
        
        charti.setPreferredSize(new java.awt.Dimension(500, 270));
        

    }
    
    CategoryDataset createDataset() {
        
        try{
            
         Class.forName("org.sqlite.JDBC").newInstance();
        Connection c = DriverManager.getConnection("jdbc:sqlite:statistics.sqlite");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("SELECT team,lost,tie,won from worldcup where championships>0");
        int nb_row=0;
        while(rs.next()){nb_row++;};
        final double[][] data = new double[3][nb_row];
        final String[] stri=new String[nb_row];
        rs=st.executeQuery("SELECT team,lost,tie,won from worldcup where championships>0");
        for(int i =0;rs.next();i++){
            
            data[0][i]=new Double(Double.parseDouble(rs.getString(2)));
            data[1][i]=Double.parseDouble(rs.getString(3));
            data[2][i]=Double.parseDouble(rs.getString(4));
            stri[i]=rs.getString(1);
            
        }
        return DatasetUtilities.createCategoryDataset("Series ", "Category ", data);
         }catch (ClassNotFoundException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }
    JFreeChart createChart(final CategoryDataset dataset) {
        
        final JFreeChart chart = ChartFactory.createBarChart3D(
            "Barre",      // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        return chart;

    }
    
}
