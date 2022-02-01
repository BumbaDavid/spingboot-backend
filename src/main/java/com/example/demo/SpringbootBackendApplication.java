package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L,"Iphone",455,"Apple","Smartphone","iOS",3.8,4,345.2,128,16,3,"https://s13emagst.akamaized.net/products/36716/36715833/images/res_1769845f4a2788695e59c389df21f056.jpg"));
			productService.save(new Product(2L,"Samsung Galaxy S20",555,"Samsung","Smartphone","Android",2.7,3,229.12,64,8,2,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4usI9o8zJ8mSysTlU8kBV0fUdWPVr0knzmQ&usqp=CAU"));
			productService.save(new Product(3L,"Xiaomi Redmi Note 9 Pro",395,"Xiaomi","Smartphone","Android",2.3,8,209,128,6,4,"https://static.quickmobileshop.com/cs-photos/products/original/redmi-note-9-dual-sim-fizic-64gb-lte-4g-alb-polar-white-3gb-ram_10066895_3_1588682318.jpg"));
			productService.save(new Product(4L,"Huawei Nova 8i",442,"Huawei","Smartphone","Android",2,8,190,128,6,4,"https://www.gadgetlab.ro/wp-content/uploads/2021/10/Huawei-Nova-8i-poza-2.jpg"));
			productService.save(new Product(5L,"Nokia G20",405,"Nokia","Smartphone","Android",2.3,8,197,64,4,4,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIRrwuL67xyGngJQnj_B3gD-qukc-r5jGr-g&usqp=CAU"));
		    productService.save(new Product(6L,"Motorola Moto g200",390,"Motorola","Smartphone","Android",2.95,8,202,128,8,3,"https://www.mobilissimo.ro/imgs/uploaded/images/Motorola/Moto-G200/G200(1).jpg"));
			productService.save(new Product(7L,"Apple Iphone 12",700,"Apple","Smartphone","iOS",3.1,5,164,128,8,2,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCcVKjGvIuKZZi_9LUjyatzgjouwcAwIymyA&usqp=CAU"));
			productService.save(new Product(8L,"Samsung Galaxy S21",657,"Samsung","Smartphone","Android",2.9,8,200,256,8,3,"https://images.samsung.com/is/image/samsung/p6pim/ro/galaxy-s21/gallery/ro-galaxy-s21-5g-g991-sm-g991bzageue-359305046"));
			productService.save(new Product(9L,"Xiaomi 11T",500,"Xiaomi","Smartphone","Android",2.6,8,203,128,8,3,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKSkSvrw-oMWkyaa34OnfRmfmxLFlBP0NDq2jsptr60MbvJNxKAUS80qz8eq5M7DBtXeA&usqp=CAU"));
		};
	}
}
