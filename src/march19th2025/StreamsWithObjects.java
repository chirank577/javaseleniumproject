package march19th2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsWithObjects {
    public static void main(String[] args) {
        //Streams have started since JDK 1.8 but prior to that we have Apache spark and hadoop
        //Java had only deficiency that is to process the data, and analyze the data, grouping the data
        //Java has a huge collection library to preserve, process and manipulate the data

        //streams are used to process the data in a declarative way

        List<Employees> l1=new ArrayList<>();
        l1.add(new Employees("chiru",4242,"Tech",90000));
        l1.add(new Employees("tejash",4243,"HR",80000));
        l1.add(new Employees("Ankit",4244,"PR",100000));
        l1.add(new Employees("Shiva",4245,"content",70000));

        Predicate<Employees> p1= new Predicate<Employees>() {
            @Override
            public boolean test(Employees employees) {
                return employees.salary()>80000;

            }
        };

        Consumer <Employees> c1=new Consumer<Employees>() {
            @Override
            public void accept(Employees employees) {
                System.out.println(employees.name()+"----"+employees.dept()+"-----"+employees.salary()+"---"+employees.empID());
            }
        };
        l1.stream().filter(p1).forEach(c1);

        System.out.println("*********************************************************************************");
        //,mapToDouble()--> It is used to convert the stream of objects to stream of double value
        //.mapToDouble() is an intermediate operation(After this operation we can perform any other operation on this set of data)
        //.mapToDouble() accepts a function interface
        l1.stream().mapToDouble(e->e.salary())
                .filter(s-> s>40000).map(s->s+s*0.1).forEach(s-> System.out.println(s));

        System.out.println("*********************************************************************************");

        l1.stream().filter(e->e.salary()>77000).forEach(s-> System.out.println(s.name()+" ___" +s.salary()));

        //during the process of stream the data is fixated, we can not add any new set of data in the middle of the stream
        l1.add(new Employees("jev",4246,"server",110000));
        l1.forEach(System.out::println);

        System.out.println("*********************************************************************************");
        l1.stream().filter(s->s.salary()>70000 && s.salary()<=120000 && s.dept().equals("server")).map(s->s.salary()*2).forEach(s-> System.out.println(s));

        l1.stream().forEach(s-> System.out.println(s.dept()+"  "+s.name()));

        //counting the num of people in each dept
        //return type of groupingby() is Map<K,List<T>>
        Map<String,Long> d1=l1.stream().collect(Collectors.groupingBy(s->s.dept(),Collectors.counting()));
        System.out.println(d1);

        System.out.println("*********************************************************************************");

        //Print the name of the empolyee whose salary is greater than 100K and belongs to server
        l1.stream().filter(s->s.salary()>100000 && s.dept().equals("server")).forEach(s-> System.out.println(s.dept()+" "+s.salary()+"   "+s.name()));


        System.out.println("*********************************************************************************");

        //printing the avg salary
        System.out.println(l1.stream().collect(Collectors.summarizingDouble(s ->s.salary())).getAverage());

        //max salary
        System.out.println(l1.stream().collect(Collectors.summarizingDouble(s ->s.salary())).getMax());

        //get mix
        System.out.println(l1.stream().collect(Collectors.summarizingDouble(s ->s.salary())).getMin());

        //prints the count of the employees
        System.out.println(l1.stream().collect(Collectors.summarizingDouble(s ->s.salary())).getCount());

        System.out.println("*********************************************************************************");

        //partitioning the data based on the salary

        //retrun type of .partitioningBy() is Map<Boolean, List<T>>
        Map<Boolean,List<Employees>> data=l1.stream().collect(Collectors.partitioningBy(s->s.salary()==100000));
        System.out.println(data);
        data.forEach((k,v)->{
            System.out.println(k);
            v.forEach( s->System.out.println(s.name()));
        {

            }});


        }







    }

