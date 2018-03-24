import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImportXMLToDatabase {
    private String folder;
    private Connection con;

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
                Evento evento = new Evento();

                item = elemento.getElementsByTagName("Dt");
                if (item.getLength() > 0) {
                    evento.setData(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("TckrSymb");
                if (item.getLength() > 0) {
                    evento.setAtivo(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("FinInstrmQty");
                if (item.getLength() > 0) {
                    evento.setVolume(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("FrstPric");
                if (item.getLength() > 0) {
                    evento.setAbertura(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("MinPric");
                if (item.getLength() > 0) {
                    evento.setMinima(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("MaxPric");
                if (item.getLength() > 0) {
                    evento.setMaxima(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("TradAvrgPric");
                if (item.getLength() > 0) {
                    evento.setMedia(item.item(0).getTextContent());
                }

                item = elemento.getElementsByTagName("LastPric");
                if (item.getLength() > 0) {
                    evento.setFechamento(item.item(0).getTextContent());
                }

                this.insertIntoStage(evento);
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

    private void insertIntoStage(Evento evento) {
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO st_bovespa"
                + "(ativo, volume, abertura, fechamento, minima, maxima, media, data) VALUES"
                + "(?,?,?,?,?,?,?,?)";

        try {
            preparedStatement = this.con.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, evento.getAtivo());
            preparedStatement.setString(2, evento.getVolume());
            preparedStatement.setString(3, evento.getAbertura());
            preparedStatement.setString(4, evento.getFechamento());
            preparedStatement.setString(5, evento.getMinima());
            preparedStatement.setString(6, evento.getMaxima());
            preparedStatement.setString(7, evento.getMedia());
            preparedStatement.setString(8, evento.getData());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

    public void setConnection (Connection con) {
        this.con = con;
    }

}
