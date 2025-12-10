package laba4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;


public class Main {

	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>();
		Map<String, Division> divisionCache = new HashMap<>(); // для уникальных подразделений
		String csvFilePath = "foreign_names.csv";
		char separator = ';';
		
		try (InputStream in = Main.class.getClassLoader().getResourceAsStream(csvFilePath)){
			if (in == null) { 
				throw new FileNotFoundException("Файл не найден в ресурсах: " + csvFilePath);
			}
			
        	CSVParser parser = new CSVParserBuilder()
        			.withSeparator(separator)
        			.withIgnoreQuotations(true)
        			.build();
        	
        	CSVReader reader = new CSVReaderBuilder(
        			new InputStreamReader(in))
                    .withCSVParser(parser)
                    .build();

            String[] nextLine;
            int lineNumber = 0;
            
            nextLine = reader.readNext();//для чтение со второй строки, где начинается информация о людях
           
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;

                try {
                    int id = Integer.parseInt(nextLine[0].trim());
                    String name = nextLine[1].trim();
                    String gender = nextLine[2].trim();
                    String birthDate = nextLine[3].trim();
                    String divName = nextLine[4].trim();
                    int salary = Integer.parseInt(nextLine[5].trim());

                    Division division = divisionCache.get(divName);
                    if (division == null) {
                        // Генерируем ID: размер мапы + 1 (1, 2, 3...)
                        int divId = divisionCache.size() + 1;
                        division = new Division(divId, divName);
                        divisionCache.put(divName, division);
                    }
                    
                    // Создаём объект и добавляем в список
                    Person person = new Person(id, name, gender, division, salary, birthDate);
                    people.add(person);

                    System.out.println("Добавлен: " + person);
                    
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка парсинга числа в строке " + lineNumber + ": " + e.getMessage());
                }
            }

        } catch (IOException | CsvValidationException e) {
            System.err.println("Ошибка при чтении CSV: " + e.getMessage());
            e.printStackTrace();
        }
	}
}
