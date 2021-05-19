package com.brunofonseca.SGOS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunofonseca.SGOS.domain.Cliente;
import com.brunofonseca.SGOS.repositories.ClienteRepository;
import com.brunofonseca.SGOS.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String cpfOuCnpj) throws UsernameNotFoundException {
		Cliente cli = repo.findByCpfOuCnpj(cpfOuCnpj);
		
		if(cli == null) {
			throw new UsernameNotFoundException(cpfOuCnpj);
		}
		
		return new UserSS(
				cli.getId(),
				cli.getCpfOuCnpj(),
				cli.getSenha(),
				cli.getPerfis());
	}
}