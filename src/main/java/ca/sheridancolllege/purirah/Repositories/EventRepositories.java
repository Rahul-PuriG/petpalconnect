package ca.sheridancolllege.purirah.Repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancolllege.purirah.bean.Event; // Assuming you have an Event class
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class EventRepositories {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;
    

    public void addEvent(Event event) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "INSERT INTO event (eventName, eventDate, eventTime, location, participantName, email, phone) VALUES "
                + "(:eventName, :eventDate, :eventTime, :location, :participantName, :email, :phone)";
    
        parameters.addValue("eventName", event.getEventName());
        parameters.addValue("eventDate", event.getEventDate());
        parameters.addValue("eventTime", event.getEventTime());
        parameters.addValue("location", event.getLocation());
        parameters.addValue("participantName", event.getParticipantName());
        parameters.addValue("email", event.getEmail());
        parameters.addValue("phone", event.getPhone());
    
        jdbc.update(query, parameters);
    }
    

    public List<Event> getEvents() {
        List<Event> eventList = new ArrayList<>();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        String query = "SELECT * FROM event";

        List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);

        for (Map<String, Object> row : rows) {
            Event event = new Event();
            event.setId((Integer) row.get("id"));
            event.setEventName((String) row.get("eventName"));
            event.setEventDate(((java.sql.Date) row.get("eventDate")).toLocalDate());
            event.setEventTime(((java.sql.Time)row.get("eventTime")).toLocalTime());
            event.setLocation((String) row.get("location"));
            event.setParticipantName((String) row.get("participantName"));
            event.setEmail((String) row.get("email"));
            event.setPhone((String) row.get("phone"));

            eventList.add(event);
        }

        return eventList;
    }

    public Event getEventById(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM event WHERE id=:num";
		parameters.addValue("num", id);
		
		ArrayList<Event> events = (ArrayList<Event>)jdbc.query(query, parameters,
				new BeanPropertyRowMapper<Event>(Event.class));
		System.err.println("ID =="+id);
		if(events.size()>0)
			return events.get(0);
		else
		return null;
	}
}
