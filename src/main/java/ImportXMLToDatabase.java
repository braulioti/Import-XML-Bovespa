import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ImportXMLToDatabase {
    private String folder;

    private List<Evento> carregarArquivo(String fileName) {
        NodeList item;

        File inputFile = new File(fileName);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(inputFile);
            NodeList lista = dom.getElementsByTagName("BizGrp");

            for (int i = 0; i < lista.getLength(); i++) {
                Element elemento = (Element) lista.item(i).getChildNodes();

                String data = new String();
                String ativo = new String();
                String volume = new String();
                String abertura = new String();
                String fechamento = new String();
                String minima = new String();
                String maxima = new String();
                String media = new String();

                item = elemento.getElementsByTagName("Dt");
                if (item.getLength() > 0) {
                    data = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("TckrSymb");
                if (item.getLength() > 0) {
                    ativo = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("FinInstrmQty");
                if (item.getLength() > 0) {
                    volume = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("FrstPric");
                if (item.getLength() > 0) {
                    abertura = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("MinPric");
                if (item.getLength() > 0) {
                    minima = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("MaxPric");
                if (item.getLength() > 0) {
                    maxima = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("TradAvrgPric");
                if (item.getLength() > 0) {
                    media = item.item(0).getTextContent();
                }

                item = elemento.getElementsByTagName("LastPric");
                if (item.getLength() > 0) {
                    fechamento = item.item(0).getTextContent();
                }

                System.out.println(ativo + " - " + data + " - " + volume + " - " + abertura  + " - " + fechamento + " - " + minima + " - " + maxima + " - " + media);

            }
            return null;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void importa() throws IOException {
        File file = new File(this.folder);
        File afile[] = file.listFiles();
        int i = 0;
        for (int j = afile.length; i < j; i++) {
            File arquivos = afile[i];
            if (arquivos.getName().toLowerCase().endsWith(".xml")) {
                this.carregarArquivo(arquivos.getPath());
            }
            break;
        }
    }
}
