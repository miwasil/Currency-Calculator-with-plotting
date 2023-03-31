import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import javax.swing.text.html.parser.Element;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Project2 {

	private final static Logger log = LogManager.getLogger(Project1.class);
	
	private final static String tocalc1 = "https://www.x-rates.com/historical/?from=";
	private final static String tocalc2= "&amount=";
	private final static String tocalc3= "&date=";
	
	private final static String file =  "tocalc2.properties";
	
	
	public static ArrayList<String[]> parse2(String currency1, String amount, String date) {
		Configurator.initialize(new DefaultConfiguration());
	    Configurator.setRootLevel(Level.TRACE);
	    URL url = null;
	    
	    ArrayList<String[]> al = new ArrayList<String[]>();
	    
		try(OutputStream outputStream = new FileOutputStream(file)) {
			url = new URL(tocalc1 + currency1 + tocalc2 + amount + tocalc3 + date);
			log.info("Trying connect to: " + url);
			Response r = Jsoup.connect(url.toString()).header("Accept-Encoding", "gzip, deflate")
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
					.header("Content-Type", "text/html; charset=ISO-8859-1").referrer("http://www.google.com")
					.ignoreContentType(true).maxBodySize(0).timeout(600000).execute();
			log.info("Successfully connected to " + url);
			log.info("Parsing the content");		
			
			
			
			Document doc = r.parse();				
			Elements tmp =  doc.select("table[class=tablesorter ratesTable]");
			log.info("Found table");
			Elements tmp2 = tmp.first().select("TBODY");
			log.info("Select tbody");
			Elements tmp3 = tmp2.select("TR");
			
			int i = 0;
			
			
			for (org.jsoup.nodes.Element el: tmp2) {
                Elements tmp4 = el.select("TR");
                log.info("select tr");
                for(org.jsoup.nodes.Element el2: tmp4){
                	String[] dane = new String[2];
                    for(int j = 0;j<2;j++){    
                        String text = el2.children().get(j).text();
                        
                        dane[j] = text;
                        
                       
                    }
                 
                    al.add(dane);
                    //System.out.println(al);
                    i++;
                  
                    
                }
			}
			log.info("Arraylist created");
			/*
			for (String[] tablica : al)
			{
				System.out.println(tablica[0]);
			}
			*/
			
			//log.trace(tmp3);
			
			//System.out.println(Arrays.toString(al.toArray()));
			
			
		} 	
		catch (FileNotFoundException e1) {
			log.error("Problems with local file: "+file);
		}
		catch (MalformedURLException e) {
			log.error("Problem with URL: " + url, e);
		}
		catch (UnknownHostException e) {
			log.error("Cannot connect to: "+url);			
		}
		catch (IOException e) {
			log.error("Exception: "+e.getLocalizedMessage(),e);
		}
		//return dane;
		return al;
		
	}
	
}	

	

