package WeatherApplication.Weatherappf.WeatherService;

import WeatherApplication.Weatherappf.Exceptions.EntityNotFoundException;


import WeatherApplication.Weatherappf.Model.Weather;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherReader weatherReader;
    private final WeatherRepository weatherRepository;
    List<Weather> weathers = new ArrayList<>();



    @PostConstruct
    public void init() {
        Iterable<Weather> weathers = weatherRepository.saveAll(weatherReader.readWeather());
        weatherRepository.saveAll(weathers);
        System.out.println("Weather for" + weatherRepository.findAll());

    }

    public List<Weather> getAll() {
        return StreamSupport.stream(weatherRepository.findAll().spliterator(), false).toList();
    }

    public List<Weather> getByCity(String city) {
        return weatherRepository.findByCityContains(city);

    }

    public Optional<Weather> getById(long id) {
        return weatherRepository.findById(id);
    }

    public Weather delete(long id) {
        Weather deleteById = getById(id).orElseThrow(() -> new EntityNotFoundException("cant delete"));

        weatherRepository.deleteById(id);
        return deleteById;
    }

    public Weather add(Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }

    public Weather update(Weather weather) {
        delete(weather.getId());
        add(weather);
        return weather;
    }


}
