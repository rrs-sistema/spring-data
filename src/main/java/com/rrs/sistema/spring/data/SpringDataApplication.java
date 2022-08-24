package com.rrs.sistema.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rrs.sistema.spring.data.service.CrudCargoService;
import com.rrs.sistema.spring.data.service.CrudFuncionarioService;
import com.rrs.sistema.spring.data.service.CrudUnidadeTrabalhoService;
import com.rrs.sistema.spring.data.service.RelatorioFuncionarioDinamico;
import com.rrs.sistema.spring.data.service.RelatoriosService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	@Autowired
	private CrudCargoService cargoService;

	@Autowired
	private RelatoriosService relatoriosService;
	
	@Autowired
	private CrudFuncionarioService funcionarioService;

	@Autowired
	private CrudUnidadeTrabalhoService unidadeTrabalhoService;

	@Autowired
	private RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorio dinamico");
			

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				case 5:
					relatorioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}