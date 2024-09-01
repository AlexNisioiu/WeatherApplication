package WeatherApplication.Weatherappf.WeatherService;

import WeatherApplication.Weatherappf.Model.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
interface WeatherRepository extends CrudRepository<Weather, Long> {
    List<Weather> findByCityContains(String city);





}
