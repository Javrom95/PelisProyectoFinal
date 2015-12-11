

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;

public class RestAPI {

	private String finalURL, name, type;
	private URLConnection conn;
	private Document doc = null;
	private Document docu = null;
	private Scanner sc = new Scanner(System.in);


	public String Name() {
		System.out.println("Write the name of the title:");
		name = sc.nextLine();
		return name;
	}

	public String enterName() {
		System.out.println("Write the name of the new register:");
		name = sc.nextLine();
		return name;
	}

	public String lookForName() {
		System.out.println("Write the name of the register:");
		name = sc.nextLine();
		return name;
	}


	public String lookForType() {
		System.out.println("In what database do you want to search, series or movies?:");
		name = sc.nextLine();
		return name;
	}

	public String Type() {
		System.out.println("Is series or movie?");
		name = sc.nextLine();
		return name;
	}

	public String enterType() {
		System.out.println("In what database do you want to save it, series or movies?:");
		name = sc.nextLine();
		return name;
	}


	public String formURL(String name, String type) {
		name = name.replace(' ', '+');
		finalURL = "http://www.omdbapi.com/?t=" + name + "&y=&plot=full&type=" + type + "&r=xml";
		return finalURL;
	}

	
	private InputStream getXMLInputStream(String urlString) throws IOException {
		URL url = null;
		InputStream stream = null;

		try {
			url = new URL(urlString);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.connect();

			stream = connection.getInputStream();

		} catch (MalformedURLException e) {

		}
		return stream;
	}

	public Document transformXML() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = (Document) builder.parse(getXMLInputStream(formURL(Name(), Type())));
		} catch (IOException e) {
			System.out.println("Couldn´t find what you were looking for:");
			ParseXML parse = new ParseXML();
			parse.submenu();

		} catch (Exception e) {
			System.out.println("Error in transformX.M.L.");
		}
		docu = doc;
		return doc;
	}
	
	public Document getDocu() {
		return docu;
	}

}
