import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)

public class Person implements Serializable {
    private int id;
    private String name;

    @XmlElementWrapper(name = "emails")
    @XmlElement(name = "email")
    private List<String> emails=new LinkedList<>();

    public Person(){}
    public Person(int id, String name) {

        this.id = id;

        this.name = name;
    }
    public void addEmail(String email){
        emails.add(email);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getEmails() {
        return emails;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emails=" + emails +
                '}';
    }
}