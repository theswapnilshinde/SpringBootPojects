package com.netprizm.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netprizm.app.entity.Template;
@Repository
public interface TemplateRepo extends JpaRepository<Template, Integer> {

	Template findAllBytemplateId(int templateId);

}
