package com.apap.tugas1.service;

import java.util.ArrayList;
import java.util.Optional;

import com.apap.tugas1.model.JabatanModel;

public interface JabatanService {
	void addJabatan(JabatanModel jabatan);
	JabatanModel getJabatanDetailById(Long id);
	ArrayList<JabatanModel> getListJabatan();
}
