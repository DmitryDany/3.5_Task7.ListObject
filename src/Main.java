import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        String nameFact;
        int ageFact;

        Scanner inText = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();
        int countUser = 0;
        for (int i = 0; i < 5; i++) {
            countUser++;
            System.out.println("Введите имя пользователя " + countUser);
            nameFact = inText.nextLine();
            System.out.println("Введите возраст пользователя " + countUser);
            ageFact = inInt.nextInt();
            User object = new User();
            object.setName(nameFact);
            object.setAge(ageFact);
            list.add(object);
        }
        Collections.sort(list, new SortByAge());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
}
static class User{
    private String name;
    private Integer age;

    void setName(String name){
        this.name=name;
    }
    boolean correctAge(int arg){
        return (0 <= arg && arg <= 125);
    }
    void setAge(Integer age){
        if (correctAge(age)){
        this.age=age;
        }
    }
    String getName(){
        return name;
    }
    Integer getAge(){
        return age;
    }
    public String toString(){
        return String.format(name + ", возраст " + age + " лет");
    }
}
}
class SortByAge implements Comparator<Main.User>{
    @Override
    public int compare(Main.User o1, Main.User o2) {
        return o1.getAge() - o2.getAge();
    }
}
