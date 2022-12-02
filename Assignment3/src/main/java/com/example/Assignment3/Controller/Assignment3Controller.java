package com.example.Assignment3.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Assignment3.Entity.GenderEntity;
import com.example.Assignment3.Entity.SalutationEntity;
import com.example.Assignment3.Service.Assignment3Service;
import com.example.Assignment3.Service.GenderService;

@RestController
public class Assignment3Controller {
	@Autowired
	Assignment3Service assignment3Service;
	@Autowired
	GenderService genderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loginform() {
		ModelAndView model = new ModelAndView();
		model.setViewName("Home");
		return model;
	}

	@PostMapping("/addSalutation")
	public String addSalutationMst(@RequestBody SalutationEntity salutationEntity) {	
			assignment3Service.addSalutationMst(salutationEntity);
			return "saved";
		
		}
	

	@GetMapping("/updatesalutation/{id}")
	public String updateSalutationMst(@RequestBody SalutationEntity salutationEntity) {

		Optional<?> salutation = assignment3Service.getSalutationID(salutationEntity.getSalutationid());
		if (salutation.isEmpty()) {
			return "Salutation Id does not exist ";
		}

		else if (salutationEntity.getCode() == null || salutationEntity.getName() == null) {
			return "Code or Name can not be null";
		} else if (salutationEntity.getCode() == "" || salutationEntity.getName() == "") {
			return "Value required";

		} else if (salutationEntity.isActiveyn() == null) {
			return "Status need to be true or false";
		} else if (salutationEntity.getGenderid() == null) {
			return "Gender id cannot be null";
		} else {
			assignment3Service.updateSalutationMst(salutationEntity);
			return "updated";
		}
	}

	@RequestMapping(value = "/listdetails", method = RequestMethod.GET)
	public List<SalutationEntity> getAllSalutationMst() {
		List<SalutationEntity> salList = (List<SalutationEntity>) assignment3Service.getAllSalutationMst();
		System.out.println(salList);
		return salList;

	}

	@RequestMapping(value = "/listgenderdetails", method = RequestMethod.GET)
	public List<GenderEntity> getAllGenderMst() {
		List<GenderEntity> genderList = (List<GenderEntity>) genderService.getAllGenderMst();
		
		return genderList;
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		Optional<?> deleteid = assignment3Service.getSalutationID(id);
		System.out.println(deleteid);
		if (deleteid == Optional.empty()) {
			return "id not found";
		} else {
			assignment3Service.deleteById(id);
			return "Deleted";
		}
	}

	@GetMapping(value = "/fillbyid/{id}")
	public Optional<?> findById(@PathVariable int id) {
		return assignment3Service.getSalutationID(id);
	}

	@GetMapping(value = "/fillbycode/{code}")
	public Optional<?> findByCode(@PathVariable String code) {
		return assignment3Service.findByCode(code);
	}
}
