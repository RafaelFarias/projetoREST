package br.com.cloud.netflix.exemplo.loja.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cloud.netflix.exemplo.loja.domain.Carro;

@FeignClient("carros")
public interface CarrosClient {

	@RequestMapping(method = RequestMethod.GET, value = "/lojas/{id}")
	List<Carro> getCarros(@PathVariable("id") String id);
}
