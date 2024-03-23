package kr.co.mayo.dreamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DreamonApplication {

	public static void main(String[] args) {
		
		//SpringApplication(12줄)을 지우면 그냥 자바 프로그램이나 마찬가지다.
		//근데 내가 톰캣을 사용하겠다고 하면, SpringApplication을 실행할 수 있는
		//톰캣(내장서버)이 부팅된다.
		//과거에는 톰캣을 따로 서버에서 부팅해줬으나, 이제는 프로그램을 실행하면
		//자동으로 톰캣이 실행되는 것.
		//그렇기 때문에 부팅과 동시에 톰캣이 사용할수 있는 서블릿 앱 컨텍스트와,
		//디스패처가 함께 실행된다.
		SpringApplication.run(DreamonApplication.class, args);
	}
}
