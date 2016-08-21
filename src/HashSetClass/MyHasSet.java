package HashSetClass;

import java.util.*;

/**
 * Created by Administrator on 8/21/2016.
 */
public class MyHasSet {
    public static void main(String[] args) {
        Set<Person> hashSet=new HashSet<Person>();
        hashSet.add(new Person("Mr.Ma",220181));
        hashSet.add(new Person("Mr.Li",220186));
        hashSet.add(new Person("Ms.Wang",220193));
        Iterator<Person> it=hashSet.iterator();
        while(it.hasNext()){
            Person person=it.next();
            System.out.println(person.getName()+"  "+person.getId_card());
        }
    }


    public class Person{
        private String name;
        private long id_card;
        public Person(String name, long id_card){
            this.name=name;
            this.id_card= id_card;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId_card() {
            return id_card;
        }

        public void setId_card(long id_card) {
            this.id_card = id_card;
        }

        public  int hashCode(){
            final  int PRIME=31;
            int result=1;
            result=PRIME*result+(int)(id_card^(id_card>>>32));
            result=PRIME*result+((name==null)?0:name.hashCode());
            return  result;
        }

        public  boolean equals(Objects obj){
            if (this==obj)
                return  true;
            if (this==null)
                return false;
            if (getClass()!=obj.getClass())
                return false;
            final Person other=(Person) obj;

            if (id_card!=other.id_card)
                return false;
            if (name==null){
                if (other.name!=null)
                    return false;
            }else if (!name.equals(other.name))
                return  false;
            return true;
        }

    }
}
