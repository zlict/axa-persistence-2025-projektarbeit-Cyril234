package ch.axa.cms.utils;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.axa.cms.models.Category;
import ch.axa.cms.models.Departement;
import ch.axa.cms.models.Warning;
import ch.axa.cms.models.Course;
import ch.axa.cms.models.Employee;
import ch.axa.cms.models.EmployeeCourse;
import ch.axa.cms.repositories.CategoryRepository;
import ch.axa.cms.repositories.CourseRepository;
import ch.axa.cms.repositories.DepartementRepository;
import ch.axa.cms.repositories.EmployeeCourseRepository;
import ch.axa.cms.repositories.EmployeeRepository;
import ch.axa.cms.repositories.WarningRepository;

@Component
public class DataLoader implements ApplicationRunner {

    
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private EmployeeCourseRepository EmployeeCourseRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private WarningRepository warningRepository;

    private List<Departement> departements = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<EmployeeCourse> employeeCourses = new ArrayList<>();
    private List<Warning> warnings = new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createCategories();
        createDepartement();
        createCours();
        createEmplyee();
        createEmployeeCourse();
        createWarning();
    }

    private void createCategories() {
        categories.add(categoryRepository.save(new Category("Klimawandel", "Kurse rund um Umwelt und Nachhaltigkeit")));
        categories.add(categoryRepository.save(new Category("Phishing", "Schutz vor betrügerischen E-Mails und Webseiten")));
        categories.add(categoryRepository.save(new Category("Datenschutz", "Rechtlicher und praktischer Datenschutz")));
        categories.add(categoryRepository.save(new Category("Cybersecurity", "IT-Sicherheit im Unternehmen")));
        categories.add(categoryRepository.save(new Category("Leadership", "Führungskompetenzen und Soft Skills")));
        categories.add(categoryRepository.save(new Category("Allgemeine Weiterbildung", "Soft Skills und Persönlichkeitsentwicklung")));
    }

    private void createCours(){
        // 20 ausgeschriebene Kurse
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(12), "Grundlagen Klimawandel", categories.get(0))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(18), "Phishing erkennen und vermeiden", categories.get(1))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(10), "Datenschutz Basics", categories.get(2))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(15), "Cybersecurity Awareness", categories.get(3))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(8), "Leadership 101", categories.get(4))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(20), "Kommunikation im Team", categories.get(5))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(14), "Nachhaltigkeit im Unternehmen", categories.get(0))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(16), "Phishing Advanced", categories.get(1))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(9), "Datenschutz für Führungskräfte", categories.get(2))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(13), "IT-Sicherheit für Mitarbeiter", categories.get(3))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(7), "Führungskompetenzen stärken", categories.get(4))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(19), "Selbstmanagement", categories.get(5))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(11), "Klimawandel und Innovation", categories.get(0))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(17), "Phishing Simulation", categories.get(1))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(6), "Datenschutz in der Praxis", categories.get(2))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(12), "Cybersecurity für Entwickler", categories.get(3))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(8), "Leadership Advanced", categories.get(4))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(21), "Kreativitätstechniken", categories.get(5))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(10), "Umweltrecht", categories.get(0))));
        courses.add(courseRepository.save(new Course(LocalDateTime.now().plusMonths(18), "Phishing für Admins", categories.get(1))));
    }

    private void createDepartement(){
        departements.add(departementRepository.save(new Departement("Management")));
        departements.add(departementRepository.save(new Departement("IT")));
        departements.add(departementRepository.save(new Departement("Personalwesen")));
        departements.add(departementRepository.save(new Departement("Finanzen")));
        departements.add(departementRepository.save(new Departement("Marketing")));
        departements.add(departementRepository.save(new Departement("Vertrieb")));
    }

    private void createEmplyee(){
        // CEO
        Employee ceo = new Employee("Max Mustermann", "max.mustermann@axa.de", departements.get(0), null);
        employees.add(employeeRepository.save(ceo));
        // Management Team
        Employee man1 = new Employee("Anna Schmidt", "anna.schmidt@axa.de", departements.get(0), ceo);
        Employee man2 = new Employee("Peter Becker", "peter.becker@axa.de", departements.get(0), ceo);
        Employee man3 = new Employee("Julia Klein", "julia.klein@axa.de", departements.get(0), ceo);
        Employee man4 = new Employee("Thomas Braun", "thomas.braun@axa.de", departements.get(0), ceo);
        Employee man5 = new Employee("Sabine Wolf", "sabine.wolf@axa.de", departements.get(0), ceo);
        employees.add(employeeRepository.save(man1));
        employees.add(employeeRepository.save(man2));
        employees.add(employeeRepository.save(man3));
        employees.add(employeeRepository.save(man4));
        employees.add(employeeRepository.save(man5));
        // Abteilungsleiter
        Employee leiterIT = new Employee("Leiter IT", "leiter.it@axa.de", departements.get(1), man1);
        Employee leiterHR = new Employee("Leiter Personalwesen", "leiter.personalwesen@axa.de", departements.get(2), man2);
        Employee leiterFin = new Employee("Leiter Finanzen", "leiter.finanzen@axa.de", departements.get(3), man3);
        Employee leiterMark = new Employee("Leiter Marketing", "leiter.marketing@axa.de", departements.get(4), man4);
        Employee leiterVertrieb = new Employee("Leiter Vertrieb", "leiter.vertrieb@axa.de", departements.get(5), man5);
        employees.add(employeeRepository.save(leiterIT));
        employees.add(employeeRepository.save(leiterHR));
        employees.add(employeeRepository.save(leiterFin));
        employees.add(employeeRepository.save(leiterMark));
        employees.add(employeeRepository.save(leiterVertrieb));
        // Mitarbeiter IT
        employees.add(employeeRepository.save(new Employee("Tim Berger", "tim.berger@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Lisa König", "lisa.koenig@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Jan Fischer", "jan.fischer@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Mia Weber", "mia.weber@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Paul Zimmer", "paul.zimmer@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Nina Schmitt", "nina.schmitt@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Felix Roth", "felix.roth@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Sophie Graf", "sophie.graf@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Leon Hahn", "leon.hahn@axa.de", departements.get(1), leiterIT)));
        employees.add(employeeRepository.save(new Employee("Marie Busch", "marie.busch@axa.de", departements.get(1), leiterIT)));
        // Mitarbeiter Personalwesen
        employees.add(employeeRepository.save(new Employee("Tom Keller", "tom.keller@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Emma Frank", "emma.frank@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Ben Lorenz", "ben.lorenz@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Lina Arnold", "lina.arnold@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Jonas Böhm", "jonas.boehm@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Maya Simon", "maya.simon@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Erik Scholz", "erik.scholz@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Lara Günther", "lara.guenther@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Finn Albrecht", "finn.albrecht@axa.de", departements.get(2), leiterHR)));
        employees.add(employeeRepository.save(new Employee("Mila Sauer", "mila.sauer@axa.de", departements.get(2), leiterHR)));
        // Mitarbeiter Finanzen
        employees.add(employeeRepository.save(new Employee("David Krüger", "david.krueger@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Lea Paul", "lea.paul@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Noah Brandt", "noah.brandt@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Marlene Voigt", "marlene.voigt@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Luis Fuchs", "luis.fuchs@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Clara Kuhn", "clara.kuhn@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Henry Horn", "henry.horn@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Ella Berg", "ella.berg@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Oskar Peter", "oskar.peter@axa.de", departements.get(3), leiterFin)));
        employees.add(employeeRepository.save(new Employee("Lilly Schuster", "lilly.schuster@axa.de", departements.get(3), leiterFin)));
        // Mitarbeiter Marketing
        employees.add(employeeRepository.save(new Employee("Matteo Engel", "matteo.engel@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Ida Busch", "ida.busch@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Moritz Dietrich", "moritz.dietrich@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Helena Pfeiffer", "helena.pfeiffer@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Samuel Otto", "samuel.otto@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Greta Ludwig", "greta.ludwig@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Jannis Haas", "jannis.haas@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Marlene König", "marlene.koenig@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Fabian Simon", "fabian.simon@axa.de", departements.get(4), leiterMark)));
        employees.add(employeeRepository.save(new Employee("Lena Schröder", "lena.schroeder@axa.de", departements.get(4), leiterMark)));
        // Mitarbeiter Vertrieb
        employees.add(employeeRepository.save(new Employee("Emil Weiß", "emil.weiss@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Johanna Schwarz", "johanna.schwarz@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Anton Zimmermann", "anton.zimmermann@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Charlotte Schröder", "charlotte.schroeder@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Mats Böhm", "mats.boehm@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Luisa Hartmann", "luisa.hartmann@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Till Busch", "till.busch@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Maja Schulte", "maja.schulte@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Julius Albers", "julius.albers@axa.de", departements.get(5), leiterVertrieb)));
        employees.add(employeeRepository.save(new Employee("Clara Vogt", "clara.vogt@axa.de", departements.get(5), leiterVertrieb)));
    }

    private void createEmployeeCourse(){
        // Beispiel: Die ersten 5 Kurse sind für alle, dann nach Departement
        // Annahme: employees und courses sind vollständig und in der gewünschten Reihenfolge befüllt
        // Beispiel für die ersten 5 Employees und 5 Kurse (analog für alle anderen):
        if (employees.size() >= 50 && courses.size() >= 20) {
            // --- Für alle Employees: Kurse 0-4 ---
            for (Employee e : employees) {
                employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 80, courses.get(0), e)));
                employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 80, courses.get(1), e)));
                employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 80, courses.get(2), e)));
                employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 80, courses.get(3), e)));
                employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 80, courses.get(4), e)));
            }
            // --- IT (departements.get(1)) ---
            for (Employee e : employees) {
                if (e.getDepartement().equals(departements.get(1))) {
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 70, 85, courses.get(5), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 70, 85, courses.get(7), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 70, 85, courses.get(9), e)));
                }
            }
            // --- Personalwesen (departements.get(2)) ---
            for (Employee e : employees) {
                if (e.getDepartement().equals(departements.get(2))) {
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 65, 75, courses.get(6), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 65, 75, courses.get(8), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 65, 75, courses.get(10), e)));
                }
            }
            // --- Finanzen (departements.get(3)) ---
            for (Employee e : employees) {
                if (e.getDepartement().equals(departements.get(3))) {
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 80, 90, courses.get(11), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 80, 90, courses.get(13), e)));
                }
            }
            // --- Marketing (departements.get(4)) ---
            for (Employee e : employees) {
                if (e.getDepartement().equals(departements.get(4))) {
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 70, courses.get(12), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 60, 70, courses.get(14), e)));
                }
            }
            // --- Vertrieb (departements.get(5)) ---
            for (Employee e : employees) {
                if (e.getDepartement().equals(departements.get(5))) {
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 75, 80, courses.get(15), e)));
                    employeeCourses.add(EmployeeCourseRepository.save(new EmployeeCourse(true, 75, 80, courses.get(17), e)));
                }
            }
        }
    }

    private void createWarning(){
        // Die meisten Employees haben keine oder 1 Warning, einige wenige haben viele
        // Wir nehmen die ersten 40 Employees: keine Warning
        // Die nächsten 5: 1 Warning
        // Die nächsten 3: 3 Warnings
        // Die letzten 2: 7 Warnings
        if (employees.size() >= 50 && employeeCourses.size() > 0) {
            // 41-45: 1 Warning
            employeeCourses.stream().filter(ec -> ec.getEmployee().equals(employees.get(40))).findFirst().ifPresent(ec -> warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(10), LocalDateTime.now().plusMonths(6), ec.getCourse()))));
            employeeCourses.stream().filter(ec -> ec.getEmployee().equals(employees.get(41))).findFirst().ifPresent(ec -> warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(10), LocalDateTime.now().plusMonths(6), ec.getCourse()))));
            employeeCourses.stream().filter(ec -> ec.getEmployee().equals(employees.get(42))).findFirst().ifPresent(ec -> warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(10), LocalDateTime.now().plusMonths(6), ec.getCourse()))));
            employeeCourses.stream().filter(ec -> ec.getEmployee().equals(employees.get(43))).findFirst().ifPresent(ec -> warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(10), LocalDateTime.now().plusMonths(6), ec.getCourse()))));
            employeeCourses.stream().filter(ec -> ec.getEmployee().equals(employees.get(44))).findFirst().ifPresent(ec -> warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(10), LocalDateTime.now().plusMonths(6), ec.getCourse()))));
            // 46-48: 3 Warnings
            for (int i = 0; i < 3; i++) {
                int empIdx = 45 + i;
                List<EmployeeCourse> ecs = new ArrayList<>();
                for (EmployeeCourse ec : employeeCourses) {
                    if (ec.getEmployee().equals(employees.get(empIdx))) ecs.add(ec);
                }
                for (int j = 0; j < 3 && j < ecs.size(); j++) {
                    warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(20*j), LocalDateTime.now().plusMonths(6+j), ecs.get(j).getCourse())));
                }
            }
            // 49-50: 7 Warnings
            for (int i = 0; i < 2; i++) {
                int empIdx = 48 + i;
                List<EmployeeCourse> ecs = new ArrayList<>();
                for (EmployeeCourse ec : employeeCourses) {
                    if (ec.getEmployee().equals(employees.get(empIdx))) ecs.add(ec);
                }
                for (int j = 0; j < 7 && j < ecs.size(); j++) {
                    warnings.add(warningRepository.save(new Warning(LocalDateTime.now().minusDays(5*j), LocalDateTime.now().plusMonths(6+j), ecs.get(j).getCourse())));
                }
            }
        }
    }   
    

}