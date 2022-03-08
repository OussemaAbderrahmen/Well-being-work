package tn.esprit.spring.wecare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Event;
import tn.esprit.spring.wecare.entities.EventDt;
import tn.esprit.spring.wecare.entities.Eventdto;
import tn.esprit.spring.wecare.entities.typef;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	@Query(value="SELECT event_name,images,type,note FROM event WHERE MONTH(start_date)=MONTH(CURRENT_DATE) ORDER BY note DESC  LIMIT 1",
			nativeQuery = true)
Eventdto PeriodeEvent();
	
@Query(value="SELECT COUNT(*) FROM `event_user` WHERE event_event_id= :id",nativeQuery = true)
int countusers(@Param("id")Long id);

@Query(value="SELECT event_name,profit FROM `event` ORDER BY profit DESC LIMIT 1",nativeQuery = true)
EventDt affichermeilleurprofitevent();

@Query(value="SELECT * from event WHERE event.type IN(SELECT event.type as typefav FROM event_user\r\n"
		+ " LEFT join user on event_user.user_user_id=user.user_id LEFT JOIN event ON event_user.event_event_id=event.event_id\r\n"
		+ "WHERE user.user_id=:id\r\n"
		+ "GROUP BY (event.type))",nativeQuery = true)
List<Event> typefavorite(@Param("id")long id);

@Query(value="SELECT event.type ,COUNT(user.user_id) as nbr, user.user_id,user.first_name\r\n"
		+ "FROM event_user LEFT join user\r\n"
		+ "on event_user.user_user_id=user.user_id\r\n"
		+ "LEFT JOIN event ON event_user.event_event_id=event.event_id\r\n"
		+ "WHERE user.user_id=:id\r\n"
		+ "GROUP BY (event.type)\r\n"
		+ "ORDER BY nbr DESC\r\n"
		+ "LIMIT 1",nativeQuery = true)
typef typeleplusparticipe(@Param("id")long id);

}
