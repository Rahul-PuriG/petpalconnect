package ca.sheridancolllege.purirah.SecurityConfig;


import java.util.ArrayList;






import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancolllege.purirah.Repositories.SecurityRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private SecurityRepository secRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Find the user based on the user name
		ca.sheridancolllege.purirah.bean.User user = secRepo.findUserByUsername(username);
		
		//if user not found throw exception
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("Could not find user");
		}
		
		//Find the roles connected to that user 
		List<String> roles = secRepo.getRolesById(user.getUserId());
		
		//convert the roles into the list of Granted authorities
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (String r: roles) {
			grantList.add(new SimpleGrantedAuthority(r));
		}
		
		//create a spring user based on our information
		//import org.springframework.security.core.userdetails.User;
		User springUser = new User(user.getUserName(),user.getEncryptedPassword(),grantList);
		
		return (UserDetails)springUser;
	}

}
