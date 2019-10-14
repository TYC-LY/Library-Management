package utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import entity.Book;

public class BookXMLParser extends DefaultHandler {

	private Book book = null;

	private final StringBuilder buff = new StringBuilder();
	private String attname = null;
	private final List<String> tags = new ArrayList<String>();

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	public BookXMLParser(InputStream is) {
		try {
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			spfactory.setValidating(false);
			SAXParser saxParser = spfactory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(this);
			xmlReader.parse(new InputSource(is));
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	public void startElement(String uri, String localName, String name, Attributes atts) throws SAXException {
		if (name.equalsIgnoreCase("entry")) {
			book = new Book();
		} else if (name.equalsIgnoreCase("db:attribute")) {
			attname = atts.getValue("name");
		} else if (name.equalsIgnoreCase("db:tag")) {
			tags.add(atts.getValue("name"));
		} else if (name.equalsIgnoreCase("link")) {
			if ("image".equalsIgnoreCase(atts.getValue("rel"))) {
				book.setImagePath(atts.getValue("href"));
			}
		}
		buff.setLength(0);
	}

	public void endElement(String uri, String localName, String name) throws SAXException {
		if (name.equalsIgnoreCase("db:attribute")) {
			String value = buff.toString().trim();
			
			// 当对应的标签存在，则直接赋值
			// 当不存在对应的标签，则设为“null”
			if ("title".equalsIgnoreCase(attname)) {
				book.setTitle(value);
				
			} else if ("author".equalsIgnoreCase(attname)) {
				book.setAuthor(value);
				
			} else if ("price".equalsIgnoreCase(attname)) {
				book.setPrice(value);
				
			} else if ("publisher".equalsIgnoreCase(attname)) {
				book.setPublisher(value);
				
			} else if ("isbn13".equalsIgnoreCase(attname)) {
				book.setISBN(value);
			}
		} else if ("summary".equalsIgnoreCase(name)) {
			book.setDescription(buff.toString());
		}
		buff.setLength(0);
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		buff.append(ch, start, length);
	}

}
