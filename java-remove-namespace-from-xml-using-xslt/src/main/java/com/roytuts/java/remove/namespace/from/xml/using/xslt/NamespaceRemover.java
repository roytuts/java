package com.roytuts.java.remove.namespace.from.xml.using.xslt;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class NamespaceRemover {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {

		NamespaceRemover remover = new NamespaceRemover();

		String resp = remover.remove();

		System.out.println(resp);
	}

	public String remove() throws SAXException, IOException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		InputStream xmlData = getClass().getClassLoader().getResourceAsStream("xml/input.xml");
		URL xsltURL = getClass().getClassLoader().getResource("xslt/Xslt2Xml.xsl");
		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlData);
		Source stylesource = new StreamSource(xsltURL.openStream(), xsltURL.toExternalForm());
		Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
		StringWriter stringWriter = new StringWriter();
		transformer.transform(new DOMSource(xmlDocument), new StreamResult(stringWriter));
		return stringWriter.toString();
	}
}
