package br.com.alura.screenmath;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmath.model.DadosSerie;
import br.com.alura.screenmath.service.ConsumoAPI;
import br.com.alura.screenmath.service.ConverteDados;

@SpringBootApplication
public class ScreenmathApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmathApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		System.out.println("Rodando spring");
		
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=53690c4a");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

}
