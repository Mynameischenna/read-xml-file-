package xml12;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlreader {

    /*
    * Get the Document Builder
    * Get Document
    * Normalize the xml structure
    * Get all the element by the tag name
    * */

    public static void main(String[] args) throws SAXException, IOException {

        //Get the Document Builder

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Get Document
            Document document = builder.parse("C:\\Users\\chenn\\eclipse-workspace\\read_xml\\src\\xml1\\NewFile.xml");

            // Normalize the xml structure
            document.getDocumentElement().normalize();

            // Get all the element by the tag name

            NodeList laptopList = document.getElementsByTagName("person");
            for(int i = 0; i <laptopList.getLength(); i++) {
                Node laptop = laptopList.item(i);
                if(laptop.getNodeType() == Node.ELEMENT_NODE) {

                    Element laptopElement = (Element) laptop;
                    System.out.println("element "+(i+1));
                    NodeList laptopDetails =  laptop.getChildNodes();
                    for(int j = 0; j < laptopDetails.getLength(); j++){
                        Node detail = laptopDetails.item(j);
                        if(detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            System.out.println("     " + detailElement.getTagName() + ": " + detailElement.getTextContent());
                        }

                    }

                }
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();


    }
}
}