// package ca.sheridancolllege.purirah.Repositories;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
// import org.springframework.stereotype.Repository;

// import ca.sheridancolllege.purirah.bean.Pet;

// import java.sql.Timestamp;
// // import java.sql.Blob;
// // import java.sql.SQLException;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

// @Repository
// public class PetRepositories {

//     @Autowired
//     private NamedParameterJdbcTemplate jdbc;

//     public void addPet(Pet pet) {
//         MapSqlParameterSource parameters = new MapSqlParameterSource();
//         String query = "INSERT INTO pet (petName, species, age, Details, image, available, breed, color, gender, size, weight, ownerName, ownerContact, vaccinated, medicalHistory, dateAdded) VALUES "
//                 + "( :petName, :species, :age, :details, :image, :available, :breed, :color, :gender, :size, :weight, :ownerName, :ownerContact, :vaccinated, :medicalHistory, :dateAdded)";
//         parameters.addValue("petName", pet.getPetName());
//         parameters.addValue("species", pet.getSpecies());
//         parameters.addValue("age", pet.getAge());
//         parameters.addValue("details", pet.getDetails());
//         parameters.addValue("image", pet.getImage());
//         parameters.addValue("available", pet.isAvailable());
//         parameters.addValue("breed", pet.getBreed());
//         parameters.addValue("color", pet.getColor());
//         parameters.addValue("gender", pet.getGender());
//         parameters.addValue("size", pet.getSize());
//         parameters.addValue("weight", pet.getWeight());
//         parameters.addValue("ownerName", pet.getOwnerName());
//         parameters.addValue("ownerContact", pet.getOwnerContact());
//         parameters.addValue("vaccinated", pet.isVaccinated());
//         parameters.addValue("medicalHistory", pet.getMedicalHistory());
//         parameters.addValue("dateAdded", pet.getDateAdded());

//         jdbc.update(query, parameters);
//     }
//     public ArrayList<Pet> getPet() {
//         ArrayList<Pet> petList = new ArrayList<>();
//         MapSqlParameterSource parameters = new MapSqlParameterSource();
//         String query = "SELECT * FROM Pet";
    
//         List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
    
//         for (Map<String, Object> row : rows) {
//             Pet pet = new Pet();
//             pet.setId((int) row.get("id"));
//             pet.setPetName((String) row.get("petName"));
//             pet.setSpecies((String) row.get("species"));
//             pet.setAge((int) row.get("age"));
//             pet.setDetails((String) row.get("details"));
    
//             // Retrieving byte[] directly without casting to Blob
//             pet.setImage((byte[]) row.get("image"));
    
//             pet.setAvailable((boolean) row.get("available"));
//             pet.setBreed((String) row.get("breed"));
//             pet.setColor((String) row.get("color"));
//             pet.setGender((String) row.get("gender"));
//             pet.setSize((String) row.get("size"));
//             pet.setWeight((double) row.get("weight"));
//             pet.setOwnerName((String) row.get("ownerName"));
//             pet.setOwnerContact((String) row.get("ownerContact"));
//             pet.setVaccinated((boolean) row.get("vaccinated"));
//             pet.setMedicalHistory((String) row.get("medicalHistory"));
            
//             Timestamp timestamp = (Timestamp) row.get("dateAdded");
//             LocalDateTime localDateTime = timestamp.toLocalDateTime();
//             pet.setDateAdded(localDateTime);
    
//             petList.add(pet);
//         }
    
//         return petList;
//     }
    
// }
