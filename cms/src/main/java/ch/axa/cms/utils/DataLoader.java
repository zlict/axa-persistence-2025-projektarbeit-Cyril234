package ch.axa.cms.utils;
/* 
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.axa.cms.models.Category;
import ch.axa.cms.models.Departement;
import ch.axa.cms.models.Warning;
import ch.axa.cms.repositories.CategoryRepository;
import ch.axa.cms.repositories.CourseRepository;
import ch.axa.cms.repositories.DepartementRepository;
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
    private EmployeeRepository employeeRepository;
    @Autowired
    private WarningRepository warningRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createCategories();
        createCours();
        createDepartement();
        createEmplyee();
        createWarning();
    }

    private void createCategories() {
        categoryRepository.save(new Category("Klimawandel", "Kurse rund um Umwelt und Nachhaltigkeit"));
        categoryRepository.save(new Category("Phishing", "Schutz vor betrügerischen E-Mails und Webseiten"));
        categoryRepository.save(new Category("Datenschutz", "Rechtlicher und praktischer Datenschutz"));
        categoryRepository.save(new Category("Cybersecurity", "IT-Sicherheit im Unternehmen"));
        categoryRepository.save(new Category("Leadership", "Führungskompetenzen und Soft Skills"));
        categoryRepository.save(new Category("Allgemeine Weiterbildung", "Soft Skills und Persönlichkeitsentwicklung"));
    }

    private void createCours(){

    }

    private void createDepartement(){
        departementRepository.save(new Departement("Management"));
        departementRepository.save(new Departement("IT"));
        departementRepository.save(new Departement("Personalwesen"));
        departementRepository.save(new Departement("Finanzen"));
        departementRepository.save(new Departement("Marketing"));
        departementRepository.save(new Departement("Vertrieb"));
    }

    private void createEmplyee(){
        
    }

    private void createWarning(){
 
    }   
    

}

*/