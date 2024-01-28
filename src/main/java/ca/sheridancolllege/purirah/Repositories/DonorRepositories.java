package ca.sheridancolllege.purirah.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancolllege.purirah.bean.Donor;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DonorRepositories {
	
    private NamedParameterJdbcTemplate jdbc;

    public void addDonor(Donor donor) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "INSERT INTO donor (donorName, donateAmount, donorEmail, donorNumber, address) VALUES "
                + "(:donorName, :donateAmount, :donorEmail, :donorNumber, :address)";

        parameters.addValue("donorName", donor.getDonorName());
        parameters.addValue("donateAmount", donor.getDonateAmount());
        parameters.addValue("donorEmail", donor.getDonorEmail());
        parameters.addValue("donorNumber", donor.getDonorNumber());
        parameters.addValue("address", donor.getAddress());

        jdbc.update(query, parameters);
    }

    public List<Donor> getDonors() {
        List<Donor> donorList = new ArrayList<>();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM donor";

        List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

        for (Map<String, Object> row : rows) {
            Donor donor = new Donor();
            donor.setId((Integer) row.get("id"));
            donor.setDonorName((String) row.get("donorName"));
            donor.setDonateAmount((double) row.get("donateAmount"));
            donor.setDonorEmail((String) row.get("donorEmail"));
            donor.setDonorNumber((String) row.get("donorNumber"));
            donor.setAddress((String) row.get("address"));

            donorList.add(donor);
        }

        return donorList;
    }

    public Donor getDonorById(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM donor WHERE id=:num";
		parameters.addValue("num", id);
		
		ArrayList<Donor> donors = (ArrayList<Donor>)jdbc.query(query, parameters,
				new BeanPropertyRowMapper<Donor>(Donor.class));
		System.err.println("ID =="+id);
		if(donors.size()>0)
			return donors.get(0);
		else
		return null;
	}
}
