package xml1;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class xml {

    public static void main(String[] args) {
        try {
        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file and create a Document object
            Document doc = dBuilder.parse("C:\\Users\\chenn\\eclipse-workspace\\read_xml\\src\\xml1\\NewFile.xml");
//            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("root");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // Step 8: Check if the node is an element (not a text node, comment, etc.)
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Step 9: Extract data from XML elements
                    String value = element.getTextContent();
                    System.out.println("Value: " + value);

                    // You can now use the 'value' as needed (e.g., store in a database).
                }
        
        }
        }
			catch(Exception e)
			{
				
			}
}}