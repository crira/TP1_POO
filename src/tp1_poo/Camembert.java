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
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
/**
 *
 * @author Matthieu
 */
public class Camembert extends AbstractPano{

     public Camembert(){
    super();
         
        
        
        // create a dataset...
        final PieDataset dataset = createSampleDataset();

        // create the chart...
        final JFreeChart chart = createChart(dataset);

        // add the chart to a panel...
        charti = new ChartPanel(chart);
        charti.setPreferredSize(new java.awt.Dimension(500, 270));
       
        

    }
     private PieDataset createSampleDataset(){
         try{
         Class.forName("org.sqlite.JDBC").newInstance();
        Connection c = DriverManager.getConnection("jdbc:sqlite:statistics.sqlite");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("SELECT continent,count(id) from worldcup group by continent");
        final DefaultPieDataset result = new DefaultPieDataset();
        for(int i =0;rs.next();i++){
            result.setValue(rs.getString(1), Integer.parseInt(rs.getString(2)));
        }
        return result;
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
     
     private JFreeChart createChart(final PieDataset dataset) {
        
        final JFreeChart chart = ChartFactory.createPieChart3D(
            "Camembert",  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setNoDataMessage("No data to display");
        return chart;
        
    }
}
   
