import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class Project1 {

	private final static Logger log = LogManager.getLogger(Project1.class);
	
	private final static String tocalc1 = "https://www.x-rates.com/calculator/?from=";
	private final static String tocalc2= "&to=";
	private final static String tocalc3= "&amount=";
	
	private final static String file =  "tocalc.properties";
	
	
	
	public static String parsetocalc(String currency1, String currency2, String amount) {
		Configurator.initialize(new DefaultConfiguration());
	    Configurator.setRootLevel(Level.TRACE);

	    URL url = null;
	    String converted = "";
	    String firstWord ="";
		try(OutputStream outputStream = new FileOutputStream(file)) {
			url = new URL(tocalc1 + currency1 + tocalc2 + currency2 + tocalc3 + amount);
			log.info("Trying connect to: " + url);
			Response r = Jsoup.connect(url.toString()).header("Accept-Encoding", "gzip, deflate")
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
					.header("Content-Type", "text/html; charset=ISO-8859-1").referrer("http://www.google.com")
					.ignoreContentType(true).maxBodySize(0).timeout(600000).execute();
			log.info("Successfully connected to " + url);
			log.info("Parsing the content");		
			
			Document doc = r.parse();				
			converted =  doc.select("span").get(3).text();
			
			String arr[] = converted.split(" ", 2);

			firstWord = arr[0];   //the
			
			
			log.info("Found span");
			log.trace(converted);
			
			
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
		return firstWord;
		
	}
	
}	

	

