package com.jonathasdeveloper.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jonathasdeveloper.entities.Atendimento;
import com.jonathasdeveloper.entities.Pet;
import com.jonathasdeveloper.entities.Tutor;
import com.jonathasdeveloper.entities.Vacina;
import com.jonathasdeveloper.entities.Veterinario;
import com.jonathasdeveloper.repositories.AtendimentoRepository;
import com.jonathasdeveloper.repositories.PetRepository;
import com.jonathasdeveloper.repositories.TutorRepository;
import com.jonathasdeveloper.repositories.VacinaRepository;
import com.jonathasdeveloper.repositories.VeterinarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private VacinaRepository vacinaRepository;

	@Autowired
	private VeterinarioRepository veterinarioRepository;

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Override
	public void run(String... args) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		Tutor t1 = new Tutor(null, "999999", "Joaquim Red");
		Tutor t2 = new Tutor(null, "888888", "Nadia Green");
		Tutor t3 = new Tutor(null, "989898", "Jose Black");
		Tutor t4 = new Tutor(null, "777777", "Jonathas");
		Tutor t5 = new Tutor(null, "11111111111", "Tatiana");

		tutorRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));

		Pet p1 = new Pet(null, "Bidu", "dachshund", "canina", "macho", "preto com manchas caramelo", t2);
		Pet p2 = new Pet(null, "Mimoso", "SRD", "felina", "macho", "Branco acinzentado", t4);
		Pet p3 = new Pet(null, "Amora", "SRD", "canina", "femea", "preto e branco", t3);
		Pet p4 = new Pet(null, "Sheik", "SRD", "canina", "macho", "marrom", t2);
		Pet p5 = new Pet(null, "Maia", "SRD", "canina", "femea", "branco", t2);
		Pet p6 = new Pet(null, "Blue", "SRD", "felina", "femea", "branco", t3);
		Pet p7 = new Pet(null, "Garrincha", "SRD", "canina", "macho", "malhado", t5);
		Pet p8 = new Pet(null, "Duda", "SRD", "canina", "macho", "preto e caramelo", t5);

		petRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));

		Veterinario v1 = new Veterinario(null, "Hans Chucrute", "88888-8");
		Veterinario v2 = new Veterinario(null, "Dazle Anne", "77777-7");

		veterinarioRepository.saveAll(Arrays.asList(v1, v2));
			  
		Vacina vac1 = new Vacina(null, "Anti Rabica", "Lab A", "100555A", "03-03-2019", 80.00, 150.00, 20);
		Vacina vac2 = new Vacina(null, "V10", "PZIFER", "222555A", "01-08-2019", 45.00, 100.00, 100);
		Vacina vac3 = new Vacina(null, "LEISHMANIOSE", "Lab Shangai Corp", "652555ZW", "02-06-2020", 52.30, 98.00, 50);
		
		vacinaRepository.saveAll(Arrays.asList(vac1, vac2, vac3));
		
		Atendimento at1 = new Atendimento(null, LocalDateTime.parse("15/02/2022 12:32:32", formatter), 3 , 1, 100.0, p2, v1);
		
		atendimentoRepository.save(at1);
		
		/*		  Vacina vac1 = new Vacina(null, "AntiRabica", "Lab A", "AB-190", "03-03-2021",
				  100.0); Vacina vac2 = new Vacina(null, "V10", "Laboratorio A", "UI-890",
				  "01-08-2020", 120.0); Vacina vac3 = new Vacina(null, "LEISHMANIOSE",
				  "VET LAB", "JH-756", "09-06-2019", 150.0); Vacina vac4 = new Vacina(null,
				  "GIARDIA", "Laboratorio B", "HJ-8989", "20-03-2019", 200.);*/
				  
					
		
	/*			  
				  Atendimento at1 = new Atendimento(null,
				  LocalDateTime.parse("15/02/2022 15:00:00", formatter),
				  StatusAtendimento.REALIZADO, TipoAtendimento.CONSULTA_SIMPLES, 100.0, p2,
				  v1); Atendimento at2 = new Atendimento(null,
				  LocalDateTime.parse("12/03/2022 09:35:45", formatter),
				  StatusAtendimento.REALIZADO, TipoAtendimento.EXAME, 150.0, p2, v1);
				  Atendimento at3 = new Atendimento(null,
				  LocalDateTime.parse("25/01/2022 10:36:12", formatter),
				  StatusAtendimento.CANCELADO, TipoAtendimento.CONSULTA_SIMPLES, 100.0, p4,
				  v2); Atendimento at4 = new Atendimento(null,
				  LocalDateTime.parse("17/01/2022 11:06:10", formatter),
				  StatusAtendimento.AGENDADO, TipoAtendimento.CONSULTA_SIMPLES, 100.0, p1, v2);
				  
				  atendimentoRepository.saveAll(Arrays.asList(at1, at2, at3, at4));
				  
				  CartaoVacina cart1 = new CartaoVacina(null, p2);*/
				 
			 

	}

}
