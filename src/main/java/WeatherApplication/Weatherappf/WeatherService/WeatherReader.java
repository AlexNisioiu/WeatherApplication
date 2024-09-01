package WeatherApplication.Weatherappf.WeatherService;



import WeatherApplication.Weatherappf.Model.Weather;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Repository
public class WeatherReader {

    public List<Weather> readWeather(){
        List<Weather> weathers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/Weather.txt"));
            long id = 1;
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                weathers.add(stringToWeather(line, id++));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return weathers;
    }

    private Weather stringToWeather(String text, long id){
        String[] tokens = text.split(":");


        Weather.WeatherBuilder weatherBuilder = Weather.builder()
                .id(id)
                .city(tokens[0])
                .temp(tokens[1])
                .umiditate(tokens[2])
                .wind(tokens[3])
                .country(tokens[4]);


        return weatherBuilder.build();
    }

}
