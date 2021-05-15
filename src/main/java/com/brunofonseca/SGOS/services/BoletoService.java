package com.brunofonseca.SGOS.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date dataOrdem) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataOrdem);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}