package me.wonwoo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 128, 1000);
//
//		int i = 128;
//		for(Integer integer : integers){
//			if(i == integer){
//				System.out.println("!23");
//			}
//		}
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
