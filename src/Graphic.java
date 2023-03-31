import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.data.category.DefaultCategoryDataset;

public class Graphic {
public static void createAndShowGUI() {
    	 	
    	
        JFrame jf = new JFrame("Exchange rates calculator- M.Wasilewski v0.1");
        
        
        
       // jf.getContentPane().add(jtext, BorderLayout.NORTH);
        
        
        JPanel jp = new JPanel(); 
        
        jp.setBounds(0,280,500,250);
        //jp.setLayout(new BorderLayout());
        
        JPanel output = new JPanel();
        output.setBackground(Color.yellow); 
        output.setBounds(0,100,500,150);
        
        
        JPanel onlyshow = new JPanel();
        onlyshow.setBounds(0,250,500,30);
        
        String communicate = String.format("%100d", 0);
        Font fo = new Font("Arial", Font.BOLD, 20);
        JTextField jtext = new JTextField(communicate);
        jtext.setEditable( false );
        jtext.setFont(fo);
        jtext.setPreferredSize( new Dimension( 300, 30 ) );
       
        
        
        JTextField outputtxt = new JTextField();
        outputtxt.setEditable( false );
        outputtxt.setFont(fo);
        outputtxt.setPreferredSize( new Dimension( 300, 30 ) );
        
        JPanel red = new JPanel();
        red.setBackground(Color.yellow);
        red.setBounds(0,0,250,100);
        
        
        JPanel yellow = new JPanel();
        yellow.setBackground(Color.yellow);
        yellow.setBounds(250,0,250,100);
        
       
        
        
        //jf.getContentPane().add(jp, BorderLayout.CENTER);
        
        
        
        JLabel lbl = new JLabel("choose the currency I will convert from");
        lbl.setVisible(true);
        JLabel lbl2 = new JLabel("choose the currency I will convert to");
        lbl2.setVisible(true);
        JLabel lbl3 = new JLabel("insert value and press 'OK'");
        lbl3.setVisible(true);
        JLabel lbl4 = new JLabel();
        //jf.getContentPane().add(lbl, BorderLayout.SOUTH);
        //jf.getContentPane().add(lbl2, BorderLayout.SOUTH);
        
        String[] choices = { "ARS Argentine Peso",
        		"AUD Australian Dollar",
        		"BHD Bahraini Dinar",
        		"BWP Botswana Pula",
        		"BRL Brazilian Real",
        		"GBP British Pound",
        		"BND Bruneian Dollar",
        		"BGN Bulgarian Lev",
        		"CAD Canadian Dollar",
        		"CLP Chilean Peso",
        		"CNY Chinese Yuan Renminbi",
        		"COP Colombian Peso",
        		"CZK Czech Koruna",
        		"DKK Danish Krone",
        		"AED Emirati Dirham",
        		"EUR Euro",
        		"HKD Hong Kong Dollar",
        		"HUF Hungarian Forint",
        		"ISK Icelandic Krona",
        		"INR Indian Rupee",
        		"IDR Indonesian Rupiah",
        		"IRR Iranian Rial",
        		"ILS Israeli Shekel",
        		"JPY Japanese Yen",
        		"KZT Kazakhstani Tenge",
        		"KWD Kuwaiti Dinar",
        		"LYD Libyan Dinar",
        		"MYR Malaysian Ringgit",
        		"MUR Mauritian Rupee",
        		"MXN Mexican Peso",
        		"NPR Nepalese Rupee",
        		"NZD New Zealand Dollar",
        		"NOK Norwegian Krone",
        		"OMR Omani Rial",
        		"PKR Pakistani Rupee",
        		"PHP Philippine Peso",
        		"PLN Polish Zloty",
        		"QAR Qatari Riyal",
        		"RON Romanian New Leu",
        		"RUB Russian Ruble",
        		"SAR Saudi Arabian Riyal",
        		"SGD Singapore Dollar",
        		"ZAR South African Rand",
        		"KRW South Korean Won",
        		"LKR Sri Lankan Rupee",
        		"SEK Swedish Krona",
        		"CHF Swiss Franc",
        		"TWD Taiwan New Dollar",
        		"THB Thai Baht",
        		"TTD Trinidadian Dollar",
        		"TRY Turkish Lira",
        		"VEF Venezuelan Bolivar",

};

        final JComboBox<String> cb = new JComboBox<String>(choices);
        final JComboBox<String> cb2 = new JComboBox<String>(choices);

        cb.setVisible(true);
        cb2.setVisible(true);
        //jf.getContentPane().add(cb, BorderLayout.SOUTH);
       // jf.getContentPane().add(cb2, BorderLayout.SOUTH);

        
        

        
        
        
        JButton b1=new JButton("1");    
        JButton b2=new JButton("2");    
        JButton b3=new JButton("3");    
        JButton b4=new JButton("4");    
        JButton b5=new JButton("5");    
        JButton b6=new JButton("6");    
        JButton b7=new JButton("7");    
        JButton b8=new JButton("8");    
        JButton b9=new JButton("9"); 
        JButton b10=new JButton("0"); 
         
        JButton b12=new JButton("C"); 
        JButton b13=new JButton("OK");
        JButton b14=new JButton("Plot");
        
         
        ActionListener myActionListener = new ActionListener() 
        {
        	String now = "0";
            String previous = "";
            String operator = "";
            String operators = "COK.Plot";
            boolean is;
           
            
            private String ifzero (String input)
            {
                
                	if (input.isEmpty())
                	{
                		return "";
                	}
                	//if (Double.parseDouble(input) % 1 == 0)
                	//{
                		//input = String.valueOf((long)(Double.parseDouble(input) + 0.5 ));//
                	input = String.valueOf((long)Double.parseDouble(input) );
                	//}
                	//else
                	//{
                		//input = String.valueOf(Double.parseDouble(input));
                	//}
                	return input;
                
            }
            
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println("Button = " + e.getActionCommand());
                
                if (operators.contains(e.getActionCommand()) ) 
                {
                    if (e.getActionCommand() == "C") 
                    {
                        now = "0";
                        previous = operator = "";
                        is = false;
                        
                        jtext.setText( String.format("%100s", now));
                    } 
                   /* if (e.getActionCommand() == "." && !previous.contains(".")) 
                    {
                        now = now + ".";
                        previous = operator = "";
                        //is = false;
                        
                        jtext.setText( String.format("%100s", now));
                    } */
                    if (e.getActionCommand() == "OK")
                    {
                    	String currency1 = cb.getItemAt(cb.getSelectedIndex());
                     	String currency2 = cb2.getItemAt(cb2.getSelectedIndex());
                    	String selectedcurrency = "<html>You selected " + currency1 +" and " +  currency2
                    	+ " with value: " + now + "<br/>The outcome is: " + "</html>" ;
                    	String arr1[] = currency1.split(" ", 2);
                    	String arr2[] = currency2.split(" ", 2);

            		            			
                    	String outputt = Project1.parsetocalc(arr1[0], arr2[0], now);
                    	System.out.println(outputt);
                    	outputtxt.setText(outputt);
                    	
                    	lbl4.setText(selectedcurrency);
                    	jtext.setText( String.format("%100s", now));
                    }
                    if (e.getActionCommand() == "Plot") 
                    {
                    	String currency1 = cb.getItemAt(cb.getSelectedIndex());
                    	String currency2 = cb2.getItemAt(cb2.getSelectedIndex());
                    	double value;
                    	String arr1[] = currency1.split(" ", 2);
                    	String arr2[] = currency2.split(" ", 2);
                    	System.out.println(arr2[1]);
                    	String series1 = currency2;  
                	    String series2 = currency1;  
                	    
                	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                	    int k=13;
                	    String calendar1 = "2022-";
                	    String calendar2 = "-05";
                	    String[] toplot = {"Euro", "US Dollar", "British Pound",""};
                	    String plotting = arr2[1];
                	    String serie = series1;
                	    for (int b = 0; b<4;b++) {
                	  
                	    for (int a = 0; a<4; a++) {
                    	for (int i = 0; i<4; i++) {
                    		try
                    		{
                    			k--;
                    			ArrayList<String[]> list = Project2.parse2(arr1[0], now, calendar1 + String.valueOf(k) + calendar2);
                    			
                    			
                    	
                    			for(int x = 0; x<list.size();x++){
                    			
                    				
                    			
                    				if ((list.get(x)[0].strip()).equals(plotting.strip()))
                    				
                    				{
                    				
                    					System.out.println(list.get(x)[0]);
                    			    
                    					value =  Double.parseDouble(list.get(x)[1]);
                    					System.out.println(value);
                    					
                    					dataset.addValue(value, serie, calendar1 + String.valueOf(k) + calendar2);  
                    				}
                    			
                    			}
                    		             	            
                    		}
                    		catch(Exception ex)
                    		{
                    			
                    		}
                    	} 
                    	k=13;
                    	calendar1="2021-";
                    	System.out.println(plotting);
                	    }
                	    calendar1="2022-";
                	    k=13;
                	    plotting = toplot[b];
                	    serie = toplot[b];
                	    }
                	    
                	    
                	    /*
                	    dataset.addValue(150, series2, "2016-12-19");  
                	    dataset.addValue(130, series2, "2016-12-20");  
                	    dataset.addValue(95, series2, "2016-12-21");  
                	    dataset.addValue(195, series2, "2016-12-22");  
                	    dataset.addValue(200, series2, "2016-12-23");  
                	    dataset.addValue(180, series2, "2016-12-24");  
                	    dataset.addValue(230, series2, "2016-12-25");  
                	    */
                    	Plot example = new Plot("Exchange rates calculator- M.Wasilewski v0.1 - PLOT", dataset);  
                        example.setAlwaysOnTop(true);  
                        example.pack();  
                        example.setSize(600, 400);  
                        example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                        example.setVisible(true);  
                        jtext.setText( String.format("%100s", now));
                    }
                    
                    else {
                    	                    		
                    		
                    		previous = ifzero(previous);

                    		jtext.setText(String.format("%100s", previous));
                    		
                    		
                    		operator = e.getActionCommand();
                    		now = "";
                    		
                    	}                    
                }
                else if(now.length()<12)
                {
                	if (is)
                	{
                		now = previous = operator = "";
                        is = false;
                	}
                    now += e.getActionCommand();
                    now = ifzero(now);
                    
                    jtext.setText(String.format("%100s", now));
                }
                
            }	
            
    	};
    	
        b1.addActionListener(myActionListener);
        b2.addActionListener(myActionListener);
        b3.addActionListener(myActionListener);
        b4.addActionListener(myActionListener);
        b5.addActionListener(myActionListener);
        b6.addActionListener(myActionListener);
        b7.addActionListener(myActionListener);
        b8.addActionListener(myActionListener);
        b9.addActionListener(myActionListener);
        b10.addActionListener(myActionListener);
        
        b12.addActionListener(myActionListener);
        b13.addActionListener(myActionListener);
        b14.addActionListener(myActionListener);
        
        
        
         
        jp.setLayout(new GridLayout(5,5));    
        
        jf.setLayout(null);
        red.add(lbl);
        red.add(cb);
        
        onlyshow.add(jtext);
        
        output.add(lbl4);
        output.add(outputtxt);
        output.add(b14);
        
        yellow.add(lbl2);
        yellow.add(cb2);
        yellow.add(lbl3);
        
        
        
        
        jp.add(b1); jp.add(b2); jp.add(b3);
        jp.add(b4); jp.add(b5); jp.add(b6); 
        jp.add(b7); jp.add(b8); jp.add(b9);
        jp.add(b10); jp.add(b12); 
        jp.add(b13);
        
        jf.add(output);
        jf.add(red);
        jf.add(yellow);
        jf.add(jp);
        jf.add(onlyshow);
        //jf.pack();
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setSize(500,750);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
   

	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }
}
