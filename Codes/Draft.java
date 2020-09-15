import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Draft {
    public static void main(String[] args) {
        Employee harry = new Employee("李明");
        Employee harry2 = (Employee) harry.clone();
        System.out.println(harry + " Copy: " + harry2 + "2");
    }
}

class SerialCloneable implements Cloneable, Serializable{

    public Object clone() {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            out.close();
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Object ret = in.readObject();
            return ret;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Employee extends SerialCloneable {
    private String name;

    public Employee(String n) {
        name = n;
    }
    public String toString() {
        return name;
    }
}