package br.com.cloud.netflix.exemplo.loja.hystrix;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.cloud.netflix.exemplo.loja.domain.Carro;
import br.com.cloud.netflix.exemplo.loja.feign.CarrosClient;

@Component
public class CarrosBean {

	@Autowired
	private CarrosClient carrosClient;

	@HystrixCommand(fallbackMethod = "cacheCarros")
	public List<Carro> getCarros(String id) {
		return carrosClient.getCarros(id);
	}

	public List<Carro> cacheCarro(String id) {
		return Arrays.asList(new Carro("Fiat", "Palio", Arrays.asList("123", "456", "789")));
	}
}
