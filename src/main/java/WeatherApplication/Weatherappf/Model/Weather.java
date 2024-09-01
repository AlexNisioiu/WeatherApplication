package WeatherApplication.Weatherappf.Model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@Entity
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(unique = true)
    private String city;

    @Column
    private String temp;

    @Column
    private String umiditate;

    @Column
    private String wind;

    @Column
    private String country;
}
