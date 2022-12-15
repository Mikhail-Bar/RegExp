import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReadXML {
    public static void main(String[] args) {
        Persons persons = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            persons = (Persons) jaxbUnmarshaller.unmarshal( new File("src/data/persons.xml") );
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for(Person person : persons.getPersons())
            System.out.println(person.toString());
    }
}
