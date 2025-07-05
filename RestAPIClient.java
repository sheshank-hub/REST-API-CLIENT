package sheshiii;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.json.JSONObject;
public class RestAPIClient {
		    private static final String API_KEY = "7a7d3d2ec3b85a7ad9a715288abc10a8"; 
		    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
		    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);    
		        System.out.println("Weather Data Fetcher");
		        System.out.println("---------------------");
		        System.out.print("Enter city name: ");
		        String city = scanner.nextLine();
		        try {
		            String weatherData = fetchWeatherData(city);
		            displayWeather(weatherData);
		        } catch (Exception e) {
		            System.err.println("Error fetching weather data: " + e.getMessage());
		        } finally {
		            scanner.close();
		        }
		    }
		    private static String fetchWeatherData(String city) throws Exception {
		        HttpClient client = HttpClient.newHttpClient();
		        String requestUrl = String.format("%s?q=%s&appid=%s&units=metric", API_URL, city, API_KEY);
		        
		        HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(requestUrl))
		                .build();
		        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		        if (response.statusCode() != 200) {
		            throw new RuntimeException("API request failed with status code: " + response.statusCode());
		        }

		        return response.body();
		    }
		    private static void displayWeather(String jsonData) {
		        JSONObject weatherJson = new JSONObject(jsonData);
		        JSONObject main = weatherJson.getJSONObject("main");
		        double temp = main.getDouble("temp");
		        double feelsLike = main.getDouble("feels_like");
		        int humidity = main.getInt("humidity");
		        double pressure = main.getDouble("pressure");
		        JSONObject weather = weatherJson.getJSONArray("weather").getJSONObject(0);
		        String description = weather.getString("description");
		        String iconCode = weather.getString("icon");
		        JSONObject wind = weatherJson.getJSONObject("wind");
		        double windSpeed = wind.getDouble("speed");
		        String cityName = weatherJson.getString("name");
		        String country = weatherJson.getJSONObject("sys").getString("country");
		        long sunriseTimestamp = weatherJson.getJSONObject("sys").getLong("sunrise");
		        long sunsetTimestamp = weatherJson.getJSONObject("sys").getLong("sunset");
		        String sunriseTime = formatTimestamp(sunriseTimestamp);
		        String sunsetTime = formatTimestamp(sunsetTimestamp);
		        System.out.println("\nWeather Details for " + cityName + ", " + country);
		        System.out.println("----------------------------------------");
		        System.out.printf("%-20s: %.1f°C (Feels like %.1f°C)%n", "Temperature", temp, feelsLike);
		        System.out.printf("%-20s: %s%n", "Conditions", capitalize(description));
		        System.out.printf("%-20s: %.1f m/s%n", "Wind Speed", windSpeed);
		        System.out.printf("%-20s: %d%%%n", "Humidity", humidity);
		        System.out.printf("%-20s: %.1f hPa%n", "Pressure", pressure);
		        System.out.printf("%-20s: %s%n", "Sunrise", sunriseTime);
		        System.out.printf("%-20s: %s%n", "Sunset", sunsetTime);
		        System.out.printf("%-20s: https://openweathermap.org/img/wn/%s@2x.png%n", "Weather Icon", iconCode);
		    }
		    private static String formatTimestamp(long timestamp) {
		        return LocalDateTime.ofInstant(
		            Instant.ofEpochSecond(timestamp), 
		            ZoneId.systemDefault()
		        ).format(TIME_FORMATTER);
		    }
		    private static String capitalize(String str) {
		        if (str == null || str.isEmpty()) {
		            return str;
		        }
		        return str.substring(0, 1).toUpperCase() + str.substring(1);
		    }
		}

