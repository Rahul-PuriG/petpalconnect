package ca.sheridancolllege.purirah.Repositories;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancolllege.purirah.bean.User;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class SecurityRepository {
	private NamedParameterJdbcTemplate jdbc;
	
	//import user from beans package
	public User findUserByUsername(String username) {
		
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "SELECT * FROM SEC_USER WHERE userName=:un";
			parameters.addValue("un", username);
			ArrayList<User> users = (ArrayList<User>)jdbc.query(query,parameters, new BeanPropertyRowMapper<User>(User.class));
			
		
			if(users.size()>0)
				return users.get(0);
			return null;
		
	}
	
	
	public List<String> getRolesById(long userId){
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT USER_ROLE.USERID ,SEC_ROLE.ROLENAME FROM USER_ROLE, "
				+ "SEC_ROLE WHERE USER_ROLE.ROLEID=SEC_ROLE.ROLEID AND USERID =:id;";
		
		parameters.addValue("id", userId);
	List<Map<String,Object>> rows = jdbc.queryForList(query,parameters);
		
	for(Map<String,Object> row:rows) {
		roles.add((String)row.get("roleName"));
	}
		return roles;
	}
	
	public void register(String username, String password, String email) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode(password);

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO SEC_USER(userName,encryptedPassword,email,ENABLED) VALUES "
				+ "(:na, :en,:email, 1)";
		
		parameters.addValue("na", username);
		parameters.addValue("en", encoded);
		parameters.addValue("email", email);
		
		
		jdbc.update(query, parameters);
		
	}
	
	public void assignRoles(long userId, long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO user_role(userId,roleId) VALUES "
				+ "(:uid, :rid)";
		
		parameters.addValue("uid", userId);
		parameters.addValue("rid", roleId);
		
		
		jdbc.update(query, parameters);
		
	}
	
}
