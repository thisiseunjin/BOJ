import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
           
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people[i] = new Person(age, name,i);
        }

        Arrays.sort(people);

        StringBuilder sb = new StringBuilder();
        for(Person p : people){
            sb.append(p.toString()).append("\n");
        }
        
        System.out.println(sb);
    }

    public static class Person implements Comparable<Person>{
        String name;
        int age;
        int order;

        public Person(int age, String name, int order){
            this.name = name;
            this.age = age;
        }

        public String toString(){
            return this.age+" "+this.name;
        }


        public int compareTo(Person p){
            if(this.age == p.age){
                return this.order-p.order;
            }
            return this.age - p.age;
        }
    }
}