package com.example.Assignment3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment3.Entity.GenderEntity;
import com.example.Assignment3.Repository.GenderRepository;

@Service("genderService")
public class GenderService {
	@Autowired
	GenderRepository genderRepository;

	public List<GenderEntity> getAllGenderMst() {
		// TODO Auto-generated method stub
		return genderRepository.findAll();
	}
	
	}

