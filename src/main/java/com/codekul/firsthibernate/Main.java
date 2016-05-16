package com.codekul.firsthibernate;

import com.codekul.firsthibernate.domain.Animal;
import com.codekul.firsthibernate.domain.Car;
import com.codekul.firsthibernate.domain.City;
import com.codekul.firsthibernate.domain.Country;
import com.codekul.firsthibernate.domain.Foodies;
import com.codekul.firsthibernate.domain.Fruit;
import com.codekul.firsthibernate.domain.Human;
import com.codekul.firsthibernate.domain.Mango;
import com.codekul.firsthibernate.domain.Resto;
import com.codekul.firsthibernate.domain.Shop;
import com.codekul.firsthibernate.domain.Teacher;
import com.codekul.firsthibernate.domain.Tiger;
import com.codekul.firsthibernate.repository.CarRepository;
import com.codekul.firsthibernate.repository.CarRepositoryImpl;
import com.codekul.firsthibernate.repository.ShopRepository;
import com.codekul.firsthibernate.repository.ShopRepositoryImpl;
import com.codekul.firsthibernate.util.HbUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Main {

    public static void main(String[] args) {
        manyToManyMapping();
    }

    public static void shopOperations() {

        Shop shop = new Shop();
        shop.setOwner("android");
        shop.setShopName("codekul.com");
        shop.addAddreses("Pune");
        shop.addAddreses("Mumbai");
        shop.addAddreses("Sangli");

        ShopRepository repository = new ShopRepositoryImpl();
        try {
            repository.insert(shop);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(shop);
    }

    public static void carOperations() {
        Car car = new Car();
        car.setId(1l);

        CarRepository carRepo = new CarRepositoryImpl();
        try {
            Car carPersistent = carRepo.query(car);
            System.out.println("Persistenet car - " + carPersistent);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void inheritanceTablePerHierarchy() {

        Tiger tiger = new Tiger();
        tiger.setAnimalName("tiger");
        tiger.setCoutry("india");
        tiger.setFromInda(true);
        tiger.setStrpeCount(30);

        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        session.save(tiger);

        Tiger tigerPersistent = session.get(Tiger.class, Long.valueOf(1));
        System.out.println("" + tigerPersistent);

        Animal animal = new Tiger();
        animal.setAnimalName("pureAnimal");
        animal.setCoutry("animalCountry");
        session.save(animal);

        Animal animalPersistent = session.get(Tiger.class, Long.valueOf(2));
        System.out.println("" + animalPersistent);

        Animal animalTiger = new Tiger();
        animalTiger.setAnimalName("pureAnimalTiger");
        animalTiger.setCoutry("animalTigerCountry");
        session.save(animalTiger);

        Animal animalTigerPersistent = session.get(Tiger.class, Long.valueOf(7));
        System.out.println("Animal Tiger - " + animalTigerPersistent);

        txn.commit();
        session.flush();
    }

    public static void inheritanceTablePerConcreteClass() {

        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();

//        Fruit fruit = new Fruit();
//        fruit.setSeason("winter");
//        session.save(fruit);
        Mango mango = new Mango();
        mango.setMangoFarms("Sangli");
        mango.setMangoType("Alfanso");
        mango.setSeason("summer");
        session.save(mango);

//        Fruit fruitPerseitent = session.get(Fruit.class, Long.valueOf(1));
//        System.out.println("Fruit is - "+fruitPerseitent);
//        Mango mangoPersistent = session.get(Mango.class, Long.valueOf(20));
//        System.out.println("Mango Persistent - " + mangoPersistent);
        txn.commit();
        session.flush();
    }

    public static void inheritanceJoined() {
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();

//        Human human = new Human();
//        human.setAge(23);
//        human.setIdHuman(908l);
//        human.setNameHuman("Android");
//        session.save(human);
//
//        Teacher teacher = new Teacher();
//        teacher.setAge(56);
//        teacher.setNameHuman("Teacher");
//        teacher.setSchool("Abhinav");
//        teacher.setSubject("Maths");
//        session.save(teacher);
        Teacher teacher = session.get(Teacher.class, Long.valueOf(2));
        System.out.println("Teacher - " + teacher);

        txn.commit();
        session.flush();
    }

    public static void criteriaExample() {
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();

        Criteria criteria = session.createCriteria(Teacher.class);
//        .add(Restrictions.eq("subject", "Maths"))
//        .add(Restrictions.in("subject",new String[]{"Android","Java","Maths"}))
//        .addOrder(Order.asc("subject"));

        criteria.setProjection(Projections.projectionList()
                .add(Projections.rowCount())
                .add(Projections.avg("age"))
        );
        //criteria.setProjection(Projections.avg("age"));

        List<Object []> listTeachers = criteria.list();
        for (Object[] d : listTeachers) {
            System.out.println(" RowCount - " + d[0]+" Age - "+ d[1]);
        }
//        for(Teacher teacher : listTeachers){
//            System.out.println(""+teacher.toString());
//        }
        txn.commit();
        session.flush();
    }
    
    public static void hibernateQueryDemo(){
        
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        
        //Query query = session.createQuery("from Teacher");
        
//        List<Teacher> listTeacher = query.list();
//        for(Teacher teacher : listTeacher){
//            System.out.println(" "+teacher);
//        }
        /*Query query = session.createQuery("select teacher.subject from Teacher teacher");
        List<String> listSubjects = query.list();
        for(String sub : listSubjects){
            System.out.println(" "+sub);
        }*/
        
        /*Query query = session.createQuery("from Teacher teacher where teacher.subject=:subject");
        query.setString("subject", "Maths");
        
        List<Teacher> listTeacher = query.list();
        for(Teacher teacher : listTeacher){
            System.out.println(""+teacher);
        }
        */
        
        Query query = session.createQuery("select city from City city join city.country country where country.idCountry=:countryId");
        query.setLong("countryId", 2);
        
        List<City> listCity = query.list();
        for(City city : listCity){
            System.out.println(""+city);
        }
        
        txn.commit();
        session.flush();
    }
    
    public static void oneToManyUniAndBiDirectional(){
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        
        City cityPune = new City();
        cityPune.setCityName("Pune");
        
        City cityMumbai = new City();
        cityMumbai.setCityName("Mumbai");
        
        List<City> cityList = new ArrayList<>();
        cityList.add(cityPune);
        cityList.add(cityMumbai);
        
        Country country = new Country();
        country.setCapital("Delhi");
        country.setNameCountry("India");
        
        cityMumbai.setCountry(country);
        cityPune.setCountry(country);
        
        country.setListCity(cityList);
        session.save(country);
        
        txn.commit();
        session.flush();
    }
    
    public static void manyToManyMapping(){
        
        Session session = HbUtil.getNowSession();
        Transaction txn = session.beginTransaction();
        
        Foodies foodiesAndroid = new Foodies();
        foodiesAndroid.setDish("Punjabi");
        foodiesAndroid.setNamePerson("Android");
        
        Foodies foodiesJava = new Foodies();
        foodiesJava.setDish("Chinise");
        foodiesJava.setNamePerson("Java");
        
        Resto restoGoodLuck = new Resto();
        restoGoodLuck.setRestoName("Good luck");
        restoGoodLuck.addFoodies(foodiesJava);
        restoGoodLuck.addFoodies(foodiesAndroid);
        
        Resto restoTandoor = new Resto();
        restoTandoor.setRestoName("Tandoor");
        restoTandoor.addFoodies(foodiesJava);
        restoTandoor.addFoodies(foodiesAndroid);
        
        foodiesAndroid.addResto(restoGoodLuck);
        foodiesAndroid.addResto(restoTandoor);
        
        foodiesJava.addResto(restoTandoor);
        foodiesJava.addResto(restoGoodLuck);
        
        session.save(foodiesAndroid);
        session.save(foodiesJava);
 
        txn.commit();
        session.flush();
    }
}
