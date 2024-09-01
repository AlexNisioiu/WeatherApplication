package WeatherApplication.Weatherappf.WeatherController;


import WeatherApplication.Weatherappf.Exceptions.EntityNotFoundException;


import WeatherApplication.Weatherappf.Model.Weather;
import WeatherApplication.Weatherappf.WeatherService.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/weathers")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public List<Weather> getAll() {
      return weatherService.getAll();
    }

    @GetMapping("/{id}")
    public Weather getById(@PathVariable long id) {
        return weatherService.getById(id).orElseThrow(() -> new EntityNotFoundException("Cant find Weather"));
    }


    @GetMapping("/names")
    public List<Weather> getByCityName(@RequestParam String city){
        if(city != null) {
            return weatherService.getByCity(city);
        }else {
            return weatherService.getAll();
        }
    }

    @DeleteMapping("/{id}")
    public Weather deleteWeather(@PathVariable long id){
       return weatherService.delete(id);
    }

    @PostMapping
    public Weather addWeather(@RequestBody Weather weather){
        return weatherService.add(weather);
    }

    @PutMapping("/{id}")
    public Weather updateWeather(@PathVariable long id, @RequestBody Weather weather){
        return weatherService.update(weather);
    }


}
