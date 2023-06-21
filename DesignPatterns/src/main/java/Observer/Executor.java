/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author amrkh
 */
public class Executor {
    public static void main(String[] args) {
        Student malik = new Student("Malik");
        Student ahmed = new Student("Ahmed");
        Student nour = new Student("Nour");
        Student amr = new Student("Amr");
        Student omar = new Student("Omar");
        Course java = new Course("Java Course");
        
        java.subscribe(omar);
          java.subscribe(malik);
            java.subscribe(amr);
              java.subscribe(nour);
                java.subscribe(ahmed);
                java.unsubscribe(omar);
                java.setAvalability(true);
    }
    
}
