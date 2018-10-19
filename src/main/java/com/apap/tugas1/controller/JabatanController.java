package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;
import com.apap.tugas1.service.ProvinsiService;

@Controller
public class JabatanController {
	@Autowired
	private PegawaiService pegawaiService;
	
	@Autowired
	private ProvinsiService provinsiService;
	
	@Autowired
	private JabatanPegawaiService jabatanPegawaiService;
	
	@Autowired
	private JabatanService jabatanService;
	//FITUR 5
	@RequestMapping(value="/jabatan/tambah",method=RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("jabatan",new JabatanModel());
		return "addJabatan";
	}
	
	@RequestMapping(value="/jabatan/tambah",method=RequestMethod.POST)
	private String addJabatanSubmit(@ModelAttribute JabatanModel jabatan) {
		jabatanService.addJabatan(jabatan);
		return "add";
	}


	@RequestMapping(value="/jabatan/view")
	private String viewJabatan(@RequestParam(value="idJabatan", required=true ) Long id, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id);
		if(jabatan ==  null) {
			return "jabatan tidak ada";
		}
		else {
			model.addAttribute("jabatan",jabatan);
		}
	 return "view-jabatan";
	
}	
	@RequestMapping(value = "/jabatan/delete", method = RequestMethod.POST)
	private String deleteJabatan(@RequestParam(value="idJabatan", required=true) Long id, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanDetailById(id);
		if (!jabatan.getPegawaiList().isEmpty()) {
			return "delete";
		}
		else {
			jabatanService.deleteJabatan(jabatan);
			return "jabatan-delete";
		}
	}



}