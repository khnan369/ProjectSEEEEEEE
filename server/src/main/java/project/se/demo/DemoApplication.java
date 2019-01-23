package project.se.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import project.se.demo.entity.Customer;
import project.se.demo.entity.District;
import project.se.demo.entity.Item;
import project.se.demo.entity.Province;
import project.se.demo.repository.*;

import java.time.LocalDate;
import java.sql.Time;
import java.sql.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	ApplicationRunner init(ItemRepository itemRepository, CustomerRepository customerRepository,
						   ShopRepository shopRepository, ProvinceRepository provinceRepository, DistrictRepository districtRepository) {
		return args -> {

			Stream.of("นครราชสีมา", "ขอนแก่น", "ชัยภูมิ").forEach(province -> {
				Province provinceshop = new Province();
				provinceshop.setProvince(province);
				provinceRepository.save(provinceshop);
			});

			Stream.of("อำเภอแก้งสนามนาง", "อำเภอขามทะเลสอ", "อำเภอขามสะแกแสง","อำเภอคง","อำเภอครบุรี","อำเภอจักราช","อำเภอเฉลิมพระเกียรติ","อำเภอโชคชัย","อำเภอชุมพวง","อำเภอด่านขุนทด",
					"อำเภอเทพารักษ์","อำเภอโนนไทย","อำเภอโนนสูง","อำเภอโนนแดง","อำเภอบัวลาย","อำเภอบัวใหญ่","อำเภอบ้านเหลื่อม","อำเภอประทาย","อำเภอปักธงชัย","อำเภอปากช่อง"
					,"อำเภอพระทองคำ","อำเภอพิมาย","อำเภอเมืองนครราชสีมา","อำเภอเมืองยาง","อำเภอลำทะเมนชัย","อำเภอวังน้ำเขียว","อำเภอเสิงสาง","อำเภอสีคิ้ว","อำเภอสีดา"
					,"อำเภอสูงเนิน","อำเภอหนองบุญมาก","อำเภอห้วยแถลง").forEach(district -> {
				Province provinceshop = provinceRepository.findById(1L);
				District districtshop = new District();
				districtshop.setDistrict(district);
				districtRepository.save(districtshop);
				provinceshop.getDistrictTran().add(districtshop);
				provinceRepository.save(provinceshop);
			});

			Stream.of("อำเภอกระนวน","อำเภอเขาสวนกวาง","อำเภอโคกโพธิ์ไชย","อำเภอชนบท","อำเภอชุมแพ","อำเภอซำสูง","อำเภอน้ำพอง","อำเภอโนนศิลา","อำเภอบ้านไผ่",
					"อำเภอบ้านฝาง","อำเภอบ้านแฮด","อำเภอเปือยน้อย","อำเภอพระยืน","อำเภอพล","อำเภอภูผาม่าน","อำเภอภูเวียง","อำเภอเมืองขอนแก่น","อำเภอมัญจาคีรี",
					"อำเภอแวงน้อย","อำเภอแวงใหญ่","อำเภอเวียงเก่า","อำเภอสีชมพู","อำเภอหนองนาคำ","อำเภอหนองเรือ","อำเภอหนองสองห้อง","อำเภออุบลรัตน์").forEach(district -> {
				Province provinceshop = provinceRepository.findById(2L);
				District districtshop = new District();
				districtshop.setDistrict(district);
				districtRepository.save(districtshop);
				provinceshop.getDistrictTran().add(districtshop);
				provinceRepository.save(provinceshop);
			});

			Stream.of("อำเภอเกษตรสมบูรณ์","อำเภอแก้งคร้อ","อำเภอคอนสวรรค์","อำเภอคอนสาร","อำเภอจัตุรัส","อำเภอซับใหญ่","อำเภอเทพสถิต","อำเภอเนินสง่า","อำเภอบ้านเขว้า",
					"อำเภอบ้านแท่น","อำเภอบำเหน็จณรงค์","อำเภอภักดีชุมพล","อำเภอภูเขียว","อำเภอเมืองชัยภูมิ","อำเภอหนองบัวแดง","อำเภอหนองบัวระเหว").forEach(district -> {
				Province provinceshop = provinceRepository.findById(3L);
				District districtshop = new District();
				districtshop.setDistrict(district);
				districtRepository.save(districtshop);
				provinceshop.getDistrictTran().add(districtshop);
				provinceRepository.save(provinceshop);
			});

			Stream.of("dekd123", "deklnw1234").forEach(username -> {
				Customer customer = new Customer();
				customer.setUsername(username);
				if(username == "dekd123"){
					customer.setPassword("12345");
					customer.setCustomerName("Mr.Bryan Saoju");
					customer.setTel("0987654321");
					customer.setEmail("sdf@gmail.com");
					customerRepository.save(customer);
				}
				if(username == "deklnw1234"){
					customer.setPassword("123");
					customer.setCustomerName("Mr.Pornhub Sajai");
					customer.setTel("0897687934");
					customer.setEmail("qweqw@gmail.com");
					customerRepository.save(customer);
				}

			});

			Stream.of("Fantasia F100N 41","Fantasia F100BK 41","Yamaha F-310","Yamaha FS100C","Carlsbro CSD230"
					,"ECHOSLAP ST04436","DW Design6 6-Piece Lacquer Shell Pack","MK 61 Key Electronic Teaching Keyboard").forEach(itemName -> {
				Item item = new Item();
				item.setItemName(itemName);
				if(itemName == "Fantasia F100N 41"){
					item.setPrice(1690);
					item.setItemNum(7);
					item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic3_zpsaoqbnfhq.png");
					itemRepository.save(item);
				}
				if(itemName == "Fantasia F100BK 41"){
					item.setPrice(1690);
					item.setItemNum(5);
					item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic4_zpswv93o1sz.png");
					itemRepository.save(item);
				}
				if(itemName == "Yamaha F-310"){
					item.setPrice(4800);
					item.setItemNum(7);
					item.setPic("http://i1378.photobucket.com/albums/ah101/khnan369/pic5_zpsilrwetkt.png");
					itemRepository.save(item);
				}
				if(itemName == "Yamaha FS100C"){
					item.setPrice(5290);
					item.setItemNum(6);
					item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic6_zpsu7darbrd.png");
					itemRepository.save(item);
				}
				if(itemName == "Carlsbro CSD230"){
					item.setPrice(18000);
					item.setItemNum(6);
					item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic7_zpsw4ee9osx.png");
					itemRepository.save(item);
				}
				if(itemName == "ECHOSLAP ST04436"){
					item.setPrice(23200);
					item.setItemNum(4);
					item.setPic("https://i1378.photobucket.com/albums/ah101/khnan369/pic8_zpsoihdwobz.png");
					itemRepository.save(item);
				}
				if(itemName == "DW Design6 6-Piece Lacquer Shell Pack"){
					item.setPrice(67590);
					item.setItemNum(3);
					item.setPic("http://i1378.photobucket.com/albums/ah101/khnan369/pic9_zpsukju8oo5.png");
					itemRepository.save(item);
				}
				if(itemName == "MK 61 Key Electronic Teaching Keyboard"){
					item.setPrice(1790);
					item.setItemNum(6);
					item.setPic("http://i1378.photobucket.com/albums/ah101/khnan369/pic10_zpsq9ftgae2.png");
					itemRepository.save(item);
				}

			});
			shopRepository.findAll().forEach(System.out::println);
			itemRepository.findAll().forEach(System.out::println);
			customerRepository.findAll().forEach(System.out::println);
			provinceRepository.findAll().forEach(System.out::println);
			districtRepository.findAll().forEach(System.out::println);
		};
	}
}

