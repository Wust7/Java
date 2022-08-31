package Base.JSON_Ajax_i18n.json;

import Base.JSON_Ajax_i18n.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    /**
     * javaBean <-->json
     */
    @Test
    public void test1(){
        Person person = new Person(1, "JYQ");
        Gson gson = new Gson();

//        javaBean -->json
        String personString = gson.toJson(person);
        System.out.println(personString);

//        javaBean <--json
        Person personJson = gson.fromJson(personString, Person.class);
        System.out.println(personJson);
    }

    /**
     * List <-->json
     */
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"1"));
        personList.add(new Person(2,"2"));


        Gson gson = new Gson();

//        List -->json
        String personString = gson.toJson(personList);
        System.out.println(personString);

//        List <--json
//        List<Person> list = gson.fromJson(personString, personList.getClass());//不行，该方法并不能完全将其转换为list

        List<Person> personJson = gson.fromJson(personString, new PersonListType().getType());
        System.out.println(personJson);
    }

    /**
     * map <-->json
     */
    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(2,"3"));
        personMap.put(4,new Person(5,"6"));

        Gson gson = new Gson();
//        map -->json
        String personJSon = gson.toJson(personMap);
        System.out.println(personJSon);
//        map <--json
//        Map<Integer,Person> personMap2 = gson.fromJson(personJSon, new PersonMapType().getType());
        //通过匿名内部类来实现
        Map<Integer,Person> personMap2 = gson.fromJson(personJSon, new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap2);


    }
}
