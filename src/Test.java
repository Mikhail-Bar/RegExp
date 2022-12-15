import java.util.*;

/*Студенты нескольких групп сдают экзамен по одному предмету, который оценивается по шкале от 1 до 10.
Вывести список студентов и их оценок для выбранной группы с сортировкой по фамилиям; по оценкам.
После списка группы вывести статистику (количество студентов, получивших 10 баллов, 9 баллов и т.д.;
среднюю успеваемость по выбранной группе).
* */
public class Test {
    public static void main(String[] args) {
        Group group1 = new Group("Number-1");
        group1.appendList(new Student("Иванов", 8));
        group1.appendList(new Student("Петров", 8));
        group1.appendList(new Student("Сидоров", 3));
        group1.appendList(new Student("Барашков", 3));

        System.out.println("Список студентов");
        group1.printStudent();
        System.out.println("Сортировка по оценке");
        group1.sortByMark();
        System.out.println("Сортировка по имени");
        group1.sortByName();
        group1.map();
    }
}
class Student{
    private String name;
    private int mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", mark=" + mark ;
    }
}
class Group {
    private String nameG;
    private LinkedList<Student> studentList = new LinkedList<>();

    public String getNameG() {
        return nameG;
    }

    public void setNameG(String nameG) {
        this.nameG = nameG;
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }

    public void appendList(Student student) {
        studentList.add(student);
    }

    public Group(String nameG) {
        this.nameG = nameG;
    }

    public void printStudent() {
        for (Student st : studentList) {
            System.out.println(st.toString());
        }
    }

    public void sortByMark(){
        studentList.sort(Comparator.comparing(Student::getMark));
        printStudent();
    }

    public void sortByName(){
        studentList.sort(Comparator.comparing(Student::getName));
        printStudent();
    }

    public void map(){
        Map<Integer, Integer> digits = new HashMap<Integer, Integer>();
        double sum = 0 , count = 0, d = 0;
        for (Student st : studentList) {
            sum = sum + st.getMark();
            count++;
            if(digits.keySet().contains(st.getMark())){
                digits.put(st.getMark(),digits.get(st.getMark())+1);
            }else {
                digits.put(st.getMark(),1);
            }
        }
        for(Map.Entry<Integer, Integer> item : digits.entrySet()){

            System.out.printf("Оценка: %d  Кол-во: %d \n", item.getKey(), item.getValue());
        }
        d = sum / count;
        System.out.printf("Средняя оценка:%.1f",d);
    }
}