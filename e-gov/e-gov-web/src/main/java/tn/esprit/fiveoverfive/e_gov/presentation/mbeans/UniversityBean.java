package tn.esprit.fiveoverfive.e_gov.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import egov.entities.University;
import egov.services.interfaces.UniversityManagementLocal;

@ManagedBean
@ViewScoped
public class UniversityBean {
	private List<University> universities = new ArrayList<>();
	private University universitySelected = new University();
	private Boolean visible = false;

	@EJB
	private UniversityManagementLocal universityManagementLocal;

	public void select(University university) {
		visible = true;
		universitySelected = university;
	}

	public String doDelete() {
		universityManagementLocal.remove(universitySelected);
		universitySelected = new University();
		visible = false;
		return "";
	}

	public String doSaveOrUpdate() {
		universityManagementLocal.update(universitySelected);
		universitySelected = new University();
		visible = false;
		return "";
	}

	public String cancel() {
		visible = false;
		return "";
	}

	public String show() {
		universitySelected = new University();
		visible = true;
		return "";
	}

	public List<University> getUniversities() {
		universities = universityManagementLocal.findAll();
		return universities;
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}

	public University getUniversitySelected() {
		return universitySelected;
	}

	public void setUniversitySelected(University universitySelected) {
		this.universitySelected = universitySelected;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
