import java.util.List;
import java.util.Map;

public class Student implements CreateFromCSV<Student> {

    private String studentId;
    private String name;

    public Student() {
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public Student createFromCSV(Map<String, String> attributes) {
        //can use a builder here too
        return new Student(attributes.get("ID"), attributes.get("Name"));
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }
}
