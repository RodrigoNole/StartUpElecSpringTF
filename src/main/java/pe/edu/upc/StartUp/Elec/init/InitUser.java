package pe.edu.upc.StartUp.Elec.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.StartUp.Elec.Model.Entity.Segment;
import pe.edu.upc.StartUp.Elec.Model.Entity.User;
import pe.edu.upc.StartUp.Elec.Model.Repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        // ROLE_XXXXX	-> Segmento Objetivo
        // ACCESS_YYYYY

        // SIEMPRE DEBE DE ESTAR COMENTADO
        // SOLO SE DEBE DESBLOQUEAR CUANDO SE CREAN USUARIO

        /*User rodrigo = new User("rodrigo", bcpe.encode("rodrigo"), Segment.CUSTOMER, 1);
        rodrigo.addAuthority("ROLE_CUSTOMER");
        rodrigo.addAuthority("ACCESS_VIEW_INFO");
        rodrigo.addAuthority("ACCESS_EDIT_INFO");
        userRepository.save(rodrigo);

        User luis = new User("luis", bcpe.encode("luis"), Segment.EMPLOYEE, 1);
        luis.addAuthority("ROLE_EMPLOYEE");
        luis.addAuthority("ACCESS_VIEW_INFO");
        luis.addAuthority("ACCESS_EDIT_INFO");
        userRepository.save(luis);

        User admin = new User("admin", bcpe.encode("admin"), Segment.EMPLOYEE, 2);
        admin.addAuthority("ROLE_ADMINISTRATOR");
        admin.addAuthority("ACCESS_ALL");
        userRepository.save(admin);*/

    }

}
